package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.domain.LibraryEntity;
import com.mapsa.library.model.dto.BookDTO;
import com.mapsa.library.model.dto.LibraryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T19:38:35+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity dtoToEntity(BookDTO d) {
        if ( d == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.title( d.getTitle() );
        bookEntity.libraryEntity( libraryDTOToLibraryEntity( d.getLibraryEntity() ) );
        bookEntity.isBorrowed( d.getIsBorrowed() );

        return bookEntity.build();
    }

    @Override
    public BookDTO entityToDto(BookEntity e) {
        if ( e == null ) {
            return null;
        }

        BookDTO.BookDTOBuilder bookDTO = BookDTO.builder();

        bookDTO.isBorrowed( e.getIsBorrowed() );
        bookDTO.title( e.getTitle() );
        bookDTO.libraryEntity( libraryEntityToLibraryDTO( e.getLibraryEntity() ) );

        return bookDTO.build();
    }

    protected LibraryEntity libraryDTOToLibraryEntity(LibraryDTO libraryDTO) {
        if ( libraryDTO == null ) {
            return null;
        }

        LibraryEntity libraryEntity = new LibraryEntity();

        libraryEntity.setCreationTime( libraryDTO.getCreationTime() );
        libraryEntity.setUpdateDate( libraryDTO.getUpdateDate() );
        libraryEntity.setIsDeleted( libraryDTO.getIsDeleted() );
        libraryEntity.setLibraryName( libraryDTO.getLibraryName() );
        List<BookEntity> list = libraryDTO.getBookEntity();
        if ( list != null ) {
            libraryEntity.setBookEntity( new ArrayList<BookEntity>( list ) );
        }

        return libraryEntity;
    }

    protected LibraryDTO libraryEntityToLibraryDTO(LibraryEntity libraryEntity) {
        if ( libraryEntity == null ) {
            return null;
        }

        LibraryDTO.LibraryDTOBuilder libraryDTO = LibraryDTO.builder();

        libraryDTO.libraryName( libraryEntity.getLibraryName() );
        List<BookEntity> list = libraryEntity.getBookEntity();
        if ( list != null ) {
            libraryDTO.bookEntity( new ArrayList<BookEntity>( list ) );
        }

        return libraryDTO.build();
    }
}
