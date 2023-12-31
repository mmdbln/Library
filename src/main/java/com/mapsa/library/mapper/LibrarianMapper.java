package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.LibrarianEntity;
import com.mapsa.library.model.dto.LibrarianDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibrarianMapper extends BaseMapper<LibrarianEntity, LibrarianDTO> {
}
