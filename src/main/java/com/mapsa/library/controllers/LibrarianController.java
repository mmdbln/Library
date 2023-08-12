package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.mapper.LibrarianMapper;
import com.mapsa.library.model.domain.LibrarianEntity;
import com.mapsa.library.model.dto.LibrarianDTO;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.LibrarianRepository;
import com.mapsa.library.services.LibrarianService;
import com.mapsa.library.services.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarian")
public class LibrarianController extends BaseController<LibrarianDTO, LibrarianEntity, LibrarianMapper, LibrarianRepository,LibrarianService> {


    public LibrarianController(LibrarianService service) {
        super(service);
    }

    @GetMapping("/{national-code}")
    public PersonDTO findByNationalCode(@PathVariable("national-code") Integer nationalCode) throws NotFoundException {
        return service.findByNationalPersonCode(nationalCode).orElseThrow(NotFoundException::new);
    }
    @GetMapping("/{code}")
    public LibrarianDTO findByCode(@PathVariable Integer code) throws NotFoundException {
        return service.findByCode(code).orElseThrow(NotFoundException::new);
    }


}
