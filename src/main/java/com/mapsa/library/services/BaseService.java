package com.mapsa.library.services;

import com.mapsa.library.mapper.BaseMapper;
import com.mapsa.library.model.domain.BaseEntity;
import com.mapsa.library.model.domain.PersonEntity;
import com.mapsa.library.model.dto.BaseDTO;
import com.mapsa.library.model.dto.PersonDTO;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<T extends BaseDTO,S extends BaseMapper<BaseEntity, BaseDTO>> {

    S mapper ;


    Optional<T> getWId(Long id);

    T create(T t);

    T update(T tUpdate);

    Boolean deleteById(Long id);

    List<T> getAll();


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
    public List<PersonDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

}
