package com.mapsa.library.services;

import com.mapsa.library.mapper.LibraryMapper;
import com.mapsa.library.model.dto.LibraryDTO;
import com.mapsa.library.model.domain.LibraryEntity;
import com.mapsa.library.repositories.LibraryRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LibraryService extends BaseService<LibraryDTO, LibraryEntity, LibraryMapper, LibraryRepository> {

    public LibraryService(LibraryMapper mapper, LibraryRepository repository) {
        super(mapper, repository);
    }

    public Optional<LibraryDTO> getLibraryByName(String name) {
        LibraryEntity targetName = repository.findAll()
                .stream()
                .filter(item -> item.getLibraryName().equals(name))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(mapper.entityToDto(targetName));
    }
}
