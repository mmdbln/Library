package com.mapsa.library.model.domain;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "librarian")
public class LibrarianEntity extends PersonEntity {
    private Integer code;
}
