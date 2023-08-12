package com.mapsa.library.services;

import com.mapsa.library.mapper.PersonMapper;
import com.mapsa.library.model.domain.PersonEntity;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PersonService extends BaseService<PersonDTO,PersonEntity,PersonMapper,PersonRepository> {
    public PersonService(PersonMapper mapper, PersonRepository repository) {
        super(mapper, repository);
    }


    public Optional<PersonDTO> findByNationalCode(Integer nationalCode){
        PersonEntity targetCode = repository.findAll()
                .stream()
                .filter(item -> item.getNationalCode().equals(nationalCode))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(mapper.entityToDto(targetCode));
    }
}
