package com.mapsa.library.controllers;

import com.mapsa.library.mapper.PersonMapper;
import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.model.domain.PersonEntity;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.PersonRepository;
import com.mapsa.library.services.BaseService;
import com.mapsa.library.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<PersonDTO, PersonEntity, PersonMapper, PersonRepository,PersonService> {


    public PersonController(PersonService service) {
        super(service);
    }

    @GetMapping("/{code}")
    public PersonDTO findByCode(@PathVariable("code") Integer nationalCode) throws NotFoundException {
        return service.findByNationalCode(nationalCode).orElseThrow(NotFoundException::new);
    }
}
