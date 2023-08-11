package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.MemberEntity;
import com.mapsa.library.model.dto.MemberDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<MemberEntity, MemberDTO> {}
