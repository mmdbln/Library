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
public class MemberService implements BaseService<MemberDTO> {

    MemberRepository repository;
    MemberMapper mapper;
    PersonService personService;


    @Override
    public List<MemberDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MemberDTO> getWId(Long id) {
        return Optional.ofNullable(mapper.entityToDto(repository.findById(id).orElse(null)));
    }

    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        MemberEntity ent = repository.save(mapper.dtoToEntity(memberDTO));
        return mapper.entityToDto(ent);
    }

    @Override
    public MemberDTO update(MemberDTO tUpdate) {
        MemberEntity ent = repository.save(mapper.dtoToEntity(tUpdate));
        return mapper.entityToDto(ent);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

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


