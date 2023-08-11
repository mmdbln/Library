package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.domain.LibraryEntity;
import com.mapsa.library.model.dto.LibraryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-06T19:21:43+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class LibraryMapperImpl implements LibraryMapper {

    @Override
    public LibraryEntity dtoToEntity(LibraryDTO d) {
        if ( d == null ) {
            return null;
        }

        LibraryEntity.LibraryEntityBuilder libraryEntity = LibraryEntity.builder();

        libraryEntity.id( d.getId() );
        libraryEntity.libraryName( d.getLibraryName() );
        List<BookEntity> list = d.getBookEntity();
        if ( list != null ) {
            libraryEntity.bookEntity( new ArrayList<BookEntity>( list ) );
        }

        return libraryEntity.build();
    }

    @Override
    public LibraryDTO entityToDto(LibraryEntity e) {
        if ( e == null ) {
            return null;
        }

        LibraryDTO.LibraryDTOBuilder libraryDTO = LibraryDTO.builder();

        libraryDTO.id( e.getId() );
        libraryDTO.libraryName( e.getLibraryName() );
        List<BookEntity> list = e.getBookEntity();
        if ( list != null ) {
            libraryDTO.bookEntity( new ArrayList<BookEntity>( list ) );
        }

        return libraryDTO.build();
    }
}
