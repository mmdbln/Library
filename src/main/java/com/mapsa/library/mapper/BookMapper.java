package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.dto.BookDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<BookEntity, BookDTO> {
}
