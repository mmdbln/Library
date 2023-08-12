package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.MemberEntity;
import com.mapsa.library.model.dto.MemberDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T19:38:36+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberEntity dtoToEntity(MemberDTO d) {
        if ( d == null ) {
            return null;
        }

        MemberEntity.MemberEntityBuilder memberEntity = MemberEntity.builder();

        memberEntity.code( d.getCode() );

        return memberEntity.build();
    }

    @Override
    public MemberDTO entityToDto(MemberEntity e) {
        if ( e == null ) {
            return null;
        }

        MemberDTO.MemberDTOBuilder memberDTO = MemberDTO.builder();

        memberDTO.code( e.getCode() );

        return memberDTO.build();
    }
}
