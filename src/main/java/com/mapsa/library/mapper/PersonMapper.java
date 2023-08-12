package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.PersonEntity;
import com.mapsa.library.model.dto.PersonDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<PersonEntity,PersonDTO> {
}
