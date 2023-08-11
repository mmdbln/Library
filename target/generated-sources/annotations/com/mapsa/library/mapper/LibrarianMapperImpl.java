package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.LibraryEntity;
import com.mapsa.library.model.dto.LibrarianDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-06T19:21:43+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class LibrarianMapperImpl implements LibrarianMapper {

    @Override
    public LibraryEntity dtoToEntity(LibrarianDTO d) {
        if ( d == null ) {
            return null;
        }

        LibraryEntity.LibraryEntityBuilder libraryEntity = LibraryEntity.builder();

        libraryEntity.id( d.getId() );

        return libraryEntity.build();
    }

    @Override
    public LibrarianDTO entityToDto(LibraryEntity e) {
        if ( e == null ) {
            return null;
        }

        LibrarianDTO.LibrarianDTOBuilder librarianDTO = LibrarianDTO.builder();

        librarianDTO.id( e.getId() );

        return librarianDTO.build();
    }
}
