package com.mapsa.library.model.dto;

import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.domain.LibraryEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class BorrowDTO extends BaseDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private BookEntity bookEntity;

}

