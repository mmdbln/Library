package com.mapsa.library.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class BookEntity extends BaseEntity{
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private LibraryEntity libraryEntity;

    @OneToOne(mappedBy = "bookEntity")
    BorrowEntity borrowEntity;
    Boolean isBorrowed;

}
