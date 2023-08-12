package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.LibrarianEntity;
import com.mapsa.library.model.dto.LibrarianDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T19:38:35+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class LibrarianMapperImpl implements LibrarianMapper {

    @Override
    public LibrarianEntity dtoToEntity(LibrarianDTO d) {
        if ( d == null ) {
            return null;
        }

        LibrarianEntity.LibrarianEntityBuilder librarianEntity = LibrarianEntity.builder();

        librarianEntity.code( d.getCode() );

        return librarianEntity.build();
    }

    @Override
    public LibrarianDTO entityToDto(LibrarianEntity e) {
        if ( e == null ) {
            return null;
        }

        LibrarianDTO.LibrarianDTOBuilder librarianDTO = LibrarianDTO.builder();

        librarianDTO.code( e.getCode() );

        return librarianDTO.build();
    }
}
