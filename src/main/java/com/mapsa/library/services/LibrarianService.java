package com.mapsa.library.services;

import com.mapsa.library.mapper.LibrarianMapper;
import com.mapsa.library.model.domain.LibrarianEntity;
import com.mapsa.library.model.dto.LibrarianDTO;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibrarianService implements BaseService<LibrarianDTO> {
    private final LibrarianRepository repository;
    private final LibrarianMapper mapper;
    private final PersonService personService;

    @Override
    public List<LibrarianDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LibrarianDTO> getWId(Long id) {
        return Optional.ofNullable(mapper.entityToDto(repository.findById(id).orElse(null)));
    }

    @Override
    public LibrarianDTO create(LibrarianDTO librarianEntity) {
        LibrarianEntity entity = repository.save(mapper.dtoToEntity(librarianEntity));
        return mapper.entityToDto(entity);
    }

    @Override
    public LibrarianDTO update(LibrarianDTO tUpdate) {
        LibrarianEntity entity = repository.save(mapper.dtoToEntity(tUpdate));
        return mapper.entityToDto(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
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