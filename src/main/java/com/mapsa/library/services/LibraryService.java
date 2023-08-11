package com.mapsa.library.services;

import com.mapsa.library.mapper.LibraryMapper;
import com.mapsa.library.model.dto.LibraryDTO;
import com.mapsa.library.model.domain.LibraryEntity;
import com.mapsa.library.repositories.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LibraryService implements BaseService<LibraryDTO> {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public List<LibraryDTO> getAll() {
        return libraryRepository.findAll()
                .stream()
                .map(libraryMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public Optional<LibraryDTO> getLibraryByName(String name) {
        LibraryEntity targetName = libraryRepository.findAll()
                .stream()
                .filter(item -> item.getLibraryName().equals(name))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(libraryMapper.entityToDto(targetName));
    }

    @Override
    public Optional<LibraryDTO> getWId(Long id) {
        return Optional.ofNullable(libraryMapper.entityToDto(libraryRepository.findById(id).orElse(null)));
    }

    @Override
    public LibraryDTO create(LibraryDTO libraryDTO) {
        LibraryEntity ent = libraryRepository.save(libraryMapper.dtoToEntity(libraryDTO));
        return libraryMapper.entityToDto(ent);
    }

    @Override
    public LibraryDTO update(LibraryDTO tUpdate) {
        LibraryEntity ent = libraryRepository.save(libraryMapper.dtoToEntity(tUpdate));
        return libraryMapper.entityToDto(ent);
    }

    @Override
    public void deleteById(Long id) {
        libraryRepository.deleteById(id);

    }

}
