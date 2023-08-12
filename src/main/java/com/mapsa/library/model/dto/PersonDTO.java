package com.mapsa.library.model.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data

public class PersonDTO extends BaseDTO {
    protected Integer nationalCode;
    protected String lName;
    protected String fName;

}
