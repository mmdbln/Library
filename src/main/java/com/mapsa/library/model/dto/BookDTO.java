package com.mapsa.library.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class BookDTO extends BaseDTO {
    private Boolean isBorrowed;
    private String title;
    private LibraryDTO libraryEntity;
    private List<BorrowDTO> borrowEntities;

}
