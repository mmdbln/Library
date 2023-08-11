package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.services.PersonService;
import com.mapsa.library.services.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<PersonDTO> {
    PersonService personService;

    public PersonController(BaseService<PersonDTO> baseService) {
        super(baseService);
    }

    @GetMapping("/{code}")
    public PersonDTO findByCode(@PathVariable("code") Integer nationalCode) throws NotFoundException {
        return personService.findByNationalCode(nationalCode).orElseThrow(NotFoundException::new);
    }
}
