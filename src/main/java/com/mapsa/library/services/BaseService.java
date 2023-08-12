package com.mapsa.library.services;

import com.mapsa.library.exceptions.BorrowedYetException;
import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.mapper.BaseMapper;
import com.mapsa.library.model.domain.BaseEntity;
import com.mapsa.library.model.dto.BaseDTO;
import com.mapsa.library.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<T extends BaseDTO, E extends BaseEntity, M extends BaseMapper<E, T>, R extends BaseRepository<E>> {
    @Autowired
    protected M mapper;
    @Autowired
    protected R repository;

    public BaseService(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Optional<T> getWId(Long id) {
        return Optional.ofNullable(mapper.entityToDto(repository.findById(id).orElse(null)));

    }

    public T create(T t) throws Exception {
        E ent = repository.save(mapper.dtoToEntity(t));
        return mapper.entityToDto(ent);
    }

    public T update(T tUpdate) throws Exception {
        E entity = repository.save(mapper.dtoToEntity(tUpdate));
        return mapper.entityToDto(entity);
    }

    public Boolean deleteById(Long id) {
        E entity = repository.findAll()
                .stream()
                .filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if (entity == null || entity.getIsDeleted())
            return false;
        entity.setIsDeleted(true);
        return true;
    }

    public List<T> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

}
