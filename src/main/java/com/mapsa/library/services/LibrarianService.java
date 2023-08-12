package com.mapsa.library.services;

import com.mapsa.library.mapper.LibrarianMapper;
import com.mapsa.library.model.domain.LibrarianEntity;
import com.mapsa.library.model.dto.LibrarianDTO;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.LibrarianRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibrarianService extends BaseService<LibrarianDTO, LibrarianEntity, LibrarianMapper, LibrarianRepository> {
    private final PersonService personService;

    public LibrarianService(LibrarianMapper mapper, LibrarianRepository repository, PersonService personService) {
        super(mapper, repository);
        this.personService = personService;
    }
    public Optional<PersonDTO> findByNationalPersonCode(Integer code) {
        return personService.findByNationalCode(code);
    }

    public Optional<LibrarianDTO> findByCode(Integer code) {
        LibrarianEntity targetCode = repository.findAll()
                .stream()
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(mapper.entityToDto(targetCode));
    }
}