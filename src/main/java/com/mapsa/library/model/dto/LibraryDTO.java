package com.mapsa.library.model.dto;

import com.mapsa.library.model.domain.BookEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class LibraryDTO extends BaseDTO{
    private String libraryName;
    private List<BookEntity> bookEntity;
}
