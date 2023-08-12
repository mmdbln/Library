package com.mapsa.library.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Library")
public class LibraryEntity  extends BaseEntity {
    private String libraryName;
    @OneToMany(mappedBy = "libraryEntity")
    List<BookEntity> bookEntity;
}
