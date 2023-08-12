package com.mapsa.library.model.domain;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Person")
public class PersonEntity extends BaseEntity {
    protected Integer nationalCode;
    private String lName;
    private String fName;

}
