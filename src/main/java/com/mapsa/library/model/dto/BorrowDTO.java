package com.mapsa.library.model.dto;

import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.domain.LibraryEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class BorrowDTO extends BaseDTO {
    private Long id;
    private String title;
    private LibraryEntity libraryEntity;
    private List<BorrowEntity> borrowEntities;
}

