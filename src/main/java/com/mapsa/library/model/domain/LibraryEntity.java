package com.mapsa.library.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Library")
public class LibraryEntity  extends PersonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libraryName;
    @OneToMany(mappedBy = "libraryEntity")
    List<BookEntity> bookEntity;

}
