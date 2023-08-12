package com.mapsa.library.model.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
@Data
public class BaseDTO {
    public Instant creationTime ;
    public Instant updateDate;
    public Boolean isDeleted = false;

}
