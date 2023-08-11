package com.mapsa.library.model.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
@Data


public class BaseDTO {
    private Long id;
    private Instant creationTime;
    private Instant updateDate;
    private Boolean isDeleted;

}
