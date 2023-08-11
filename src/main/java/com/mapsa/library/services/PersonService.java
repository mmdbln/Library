package com.mapsa.library.services;

import com.mapsa.library.mapper.PersonMapper;
import com.mapsa.library.model.domain.PersonEntity;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PersonService extends BaseService<PersonDTO> {
    PersonRepository repository;
    PersonMapper mapper;
    @Override
    public Optional<PersonDTO> getWId(Long id) {
        return Optional.ofNullable(mapper.entityToDto(repository.findById(id).orElse(null)));

    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        PersonEntity ent = repository.save(mapper.dtoToEntity(personDTO));
        return mapper.entityToDto(ent);    }

    @Override
    public PersonDTO update(PersonDTO tUpdate) {
        PersonEntity entity = repository.save(mapper.dtoToEntity(tUpdate));
        return mapper.entityToDto(entity);    }

    @Override
    public Boolean deleteById(Long id) {
        PersonEntity entity = repository.findAll()
                .stream()
                .filter(item->item.getId().equals(id)).findFirst().orElse(null);
        if (entity == null || entity.getIsDeleted())
            return false;
        entity.setIsDeleted(true);
        return true;
    }

    @Override
    public List<PersonDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
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