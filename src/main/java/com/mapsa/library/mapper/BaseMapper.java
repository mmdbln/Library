package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BaseEntity;
import com.mapsa.library.model.dto.BaseDTO;
import org.mapstruct.Mapper;

public interface BaseMapper<ENTITY extends BaseEntity,DTO extends BaseDTO> {
    ENTITY dtoToEntity(DTO d);
    DTO entityToDto(ENTITY e);
}
