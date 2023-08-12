package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BaseEntity;
import com.mapsa.library.model.dto.BaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;

@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface BaseMapper<ENTITY extends BaseEntity,DTO extends BaseDTO> {
    ENTITY dtoToEntity(DTO d);
    DTO entityToDto(ENTITY e);
}
