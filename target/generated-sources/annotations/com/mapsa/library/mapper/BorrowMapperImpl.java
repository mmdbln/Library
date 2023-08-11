package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.dto.BorrowDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-06T19:21:43+0330",
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

        borrowEntity.id( d.getId() );

        return borrowEntity.build();
    }

    @Override
    public BorrowDTO entityToDto(BorrowEntity e) {
        if ( e == null ) {
            return null;
        }

        BorrowDTO.BorrowDTOBuilder borrowDTO = BorrowDTO.builder();

        borrowDTO.id( e.getId() );

        return borrowDTO.build();
    }
}
