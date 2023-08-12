package com.mapsa.library.services;

import com.mapsa.library.mapper.MemberMapper;
import com.mapsa.library.model.domain.MemberEntity;
import com.mapsa.library.model.dto.MemberDTO;
import com.mapsa.library.model.dto.PersonDTO;
import com.mapsa.library.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService extends BaseService<MemberDTO, MemberEntity, MemberMapper, MemberRepository> {

    PersonService personService;

    public MemberService(MemberMapper mapper, MemberRepository repository) {
        super(mapper, repository);
    }

    public Optional<PersonDTO> findByNationalPersonCode(Integer code) {
        return personService.findByNationalCode(code);
    }

    public Optional<MemberDTO> findByCode(Integer code) {
        MemberEntity targetCode = repository.findAll()
                .stream()
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(mapper.entityToDto(targetCode));
    }
}


