package com.mapsa.library.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class MemberDTO extends PersonDTO{
    private Integer code;
}
