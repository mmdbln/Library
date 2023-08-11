package com.mapsa.library.controllers;

import com.mapsa.library.model.dto.BaseDTO;
import com.mapsa.library.services.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class BaseController<Dto extends BaseDTO>  {
    @Autowired
    BaseService<Dto> baseService;

    @GetMapping
    public List<Dto> findAll() {
        return baseService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Dto> getById(@PathVariable Long id) {
        return baseService.getWId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dto> deleteById(@PathVariable Long id) {
        baseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<Dto> createBook(@RequestBody Dto dto) {
        baseService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Dto> updateBook(@RequestBody Dto dto) {
        baseService.update(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
