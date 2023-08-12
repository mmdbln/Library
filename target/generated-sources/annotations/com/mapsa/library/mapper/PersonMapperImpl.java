package com.mapsa.library.mapper;

import com.mapsa.library.model.domain.PersonEntity;
import com.mapsa.library.model.dto.PersonDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T19:38:35+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity dtoToEntity(PersonDTO d) {
        if ( d == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setCreationTime( d.getCreationTime() );
        personEntity.setUpdateDate( d.getUpdateDate() );
        personEntity.setIsDeleted( d.getIsDeleted() );
        personEntity.setNationalCode( d.getNationalCode() );
        personEntity.setLName( d.getLName() );
        personEntity.setFName( d.getFName() );

        return personEntity;
    }

    @Override
    public PersonDTO entityToDto(PersonEntity e) {
        if ( e == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setCreationTime( e.getCreationTime() );
        personDTO.setUpdateDate( e.getUpdateDate() );
        personDTO.setIsDeleted( e.getIsDeleted() );
        personDTO.setNationalCode( e.getNationalCode() );
        personDTO.setLName( e.getLName() );
        personDTO.setFName( e.getFName() );

        return personDTO;
    }
}
