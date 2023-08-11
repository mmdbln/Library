package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.model.dto.LibrarianDTO;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.services.LibrarianService;
import com.mapsa.library.services.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarian")
public class LibrarianController extends BaseController<LibrarianDTO> {
    LibrarianService librarianService;
    public LibrarianController(BaseService<LibrarianDTO> baseService) {
        super(baseService);
    }

    @GetMapping("/{national-code}")
    public PersonDTO findByNationalCode(@PathVariable("national-code") Integer nationalCode) throws NotFoundException {
        return librarianService.findByNationalPersonCode(nationalCode).orElseThrow(NotFoundException::new);
    }
    @GetMapping("/{code}")
    public LibrarianDTO findByCode(@PathVariable Integer code) throws NotFoundException {
        return librarianService.findByCode(code).orElseThrow(NotFoundException::new);
    }


}
