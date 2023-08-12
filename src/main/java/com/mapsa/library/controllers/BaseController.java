package com.mapsa.library.controllers;

import com.mapsa.library.mapper.BaseMapper;
import com.mapsa.library.model.domain.BaseEntity;
import com.mapsa.library.model.dto.BaseDTO;
import com.mapsa.library.repositories.BaseRepository;
import com.mapsa.library.services.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class BaseController<T extends BaseDTO,E extends BaseEntity,M extends BaseMapper<E, T>,R extends BaseRepository<E>,B extends BaseService<T,E,M,R>>  {
    @Autowired
    B service;

    @GetMapping
    public List<T> findAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<T> getById(@PathVariable Long id) {
        return service.getWId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<T> create(@RequestBody T dto) throws Exception {
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T dto) throws Exception {
        service.update(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
