package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.dto.BorrowDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowMapper extends BaseMapper<BorrowEntity, BorrowDTO> {
}
