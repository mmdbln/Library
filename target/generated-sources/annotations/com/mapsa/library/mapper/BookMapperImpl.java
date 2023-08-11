package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.domain.LibraryEntity;
import com.mapsa.library.model.dto.BookDTO;
import com.mapsa.library.model.dto.BorrowDTO;
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
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity dtoToEntity(BookDTO d) {
        if ( d == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.id( d.getId() );
        bookEntity.title( d.getTitle() );
        bookEntity.libraryEntity( libraryDTOToLibraryEntity( d.getLibraryEntity() ) );
        bookEntity.borrowEntities( borrowDTOListToBorrowEntityList( d.getBorrowEntities() ) );

        return bookEntity.build();
    }

    @Override
    public BookDTO entityToDto(BookEntity e) {
        if ( e == null ) {
            return null;
        }

        BookDTO.BookDTOBuilder bookDTO = BookDTO.builder();

        bookDTO.id( e.getId() );
        bookDTO.title( e.getTitle() );
        bookDTO.libraryEntity( libraryEntityToLibraryDTO( e.getLibraryEntity() ) );
        bookDTO.borrowEntities( borrowEntityListToBorrowDTOList( e.getBorrowEntities() ) );

        return bookDTO.build();
    }

    protected LibraryEntity libraryDTOToLibraryEntity(LibraryDTO libraryDTO) {
        if ( libraryDTO == null ) {
            return null;
        }

        LibraryEntity.LibraryEntityBuilder libraryEntity = LibraryEntity.builder();

        libraryEntity.id( libraryDTO.getId() );
        libraryEntity.libraryName( libraryDTO.getLibraryName() );
        List<BookEntity> list = libraryDTO.getBookEntity();
        if ( list != null ) {
            libraryEntity.bookEntity( new ArrayList<BookEntity>( list ) );
        }

        return libraryEntity.build();
    }

    protected BorrowEntity borrowDTOToBorrowEntity(BorrowDTO borrowDTO) {
        if ( borrowDTO == null ) {
            return null;
        }

        BorrowEntity.BorrowEntityBuilder borrowEntity = BorrowEntity.builder();

        borrowEntity.id( borrowDTO.getId() );

        return borrowEntity.build();
    }

    protected List<BorrowEntity> borrowDTOListToBorrowEntityList(List<BorrowDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<BorrowEntity> list1 = new ArrayList<BorrowEntity>( list.size() );
        for ( BorrowDTO borrowDTO : list ) {
            list1.add( borrowDTOToBorrowEntity( borrowDTO ) );
        }

        return list1;
    }

    protected LibraryDTO libraryEntityToLibraryDTO(LibraryEntity libraryEntity) {
        if ( libraryEntity == null ) {
            return null;
        }

        LibraryDTO.LibraryDTOBuilder libraryDTO = LibraryDTO.builder();

        libraryDTO.id( libraryEntity.getId() );
        libraryDTO.libraryName( libraryEntity.getLibraryName() );
        List<BookEntity> list = libraryEntity.getBookEntity();
        if ( list != null ) {
            libraryDTO.bookEntity( new ArrayList<BookEntity>( list ) );
        }

        return libraryDTO.build();
    }

    protected BorrowDTO borrowEntityToBorrowDTO(BorrowEntity borrowEntity) {
        if ( borrowEntity == null ) {
            return null;
        }

        BorrowDTO.BorrowDTOBuilder borrowDTO = BorrowDTO.builder();

        borrowDTO.id( borrowEntity.getId() );

        return borrowDTO.build();
    }

    protected List<BorrowDTO> borrowEntityListToBorrowDTOList(List<BorrowEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<BorrowDTO> list1 = new ArrayList<BorrowDTO>( list.size() );
        for ( BorrowEntity borrowEntity : list ) {
            list1.add( borrowEntityToBorrowDTO( borrowEntity ) );
        }

        return list1;
    }
}
