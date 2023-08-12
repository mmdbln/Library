package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.dto.BorrowDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T19:38:36+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class BorrowMapperImpl implements BorrowMapper {

    @Override
    public BorrowEntity dtoToEntity(BorrowDTO d) {
        if ( d == null ) {
            return null;
        }

        BorrowEntity.BorrowEntityBuilder borrowEntity = BorrowEntity.builder();

        borrowEntity.startDate( d.getStartDate() );
        borrowEntity.endDate( d.getEndDate() );
        borrowEntity.bookEntity( d.getBookEntity() );

        return borrowEntity.build();
    }

    @Override
    public BorrowDTO entityToDto(BorrowEntity e) {
        if ( e == null ) {
            return null;
        }

        BorrowDTO.BorrowDTOBuilder borrowDTO = BorrowDTO.builder();

        borrowDTO.startDate( e.getStartDate() );
        borrowDTO.endDate( e.getEndDate() );
        borrowDTO.bookEntity( e.getBookEntity() );

        return borrowDTO.build();
    }
}
