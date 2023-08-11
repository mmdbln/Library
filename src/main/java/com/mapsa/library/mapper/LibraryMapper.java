package com.mapsa.library.mapper;

import com.mapsa.library.model.dto.LibraryDTO;
import com.mapsa.library.model.domain.LibraryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface LibraryMapper extends BaseMapper<LibraryEntity, LibraryDTO> {

}
