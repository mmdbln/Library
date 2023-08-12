package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.mapper.MemberMapper;
import com.mapsa.library.model.domain.MemberEntity;
import com.mapsa.library.model.dto.MemberDTO;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.MemberRepository;
import com.mapsa.library.services.MemberService;
import com.mapsa.library.services.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController extends BaseController<MemberDTO, MemberEntity, MemberMapper, MemberRepository,MemberService> {


    public MemberController(MemberService service) {
        super(service);
    }

    @GetMapping("/{national-code}")
    public PersonDTO findByNationalCode(@PathVariable("national-code") Integer nationalCode) throws NotFoundException {
        return service.findByNationalPersonCode(nationalCode).orElseThrow(NotFoundException::new);
    }
    @GetMapping("/{code}")
    public MemberDTO findByCode(@PathVariable Integer code) throws NotFoundException {
        return service.findByCode(code).orElseThrow(NotFoundException::new);
    }


}
