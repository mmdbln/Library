package com.mapsa.library.services;

import com.mapsa.library.mapper.BookMapper;
import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.dto.BookDTO;
import com.mapsa.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService implements BaseService<BookDTO> {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDTO> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::entityToDto)
                .collect(Collectors.toList());
    }
    public Optional<BookDTO> findBookByTitle(String title){
        BookEntity targetName = bookRepository.findAll()
                .stream()
                .filter(item -> item.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(bookMapper.entityToDto(targetName));
    }

    @Override
    public Optional<BookDTO> getWId(Long id) {
        return Optional.ofNullable(bookMapper.entityToDto(bookRepository.findById(id).orElse(null)));
    }

    @Override
    public BookDTO create(BookDTO book) {
        BookEntity bookEnt = bookRepository.save(bookMapper.dtoToEntity(book));
        return bookMapper.entityToDto(bookEnt);
    }

    @Override
    public BookDTO update(BookDTO tUpdate) {
        BookEntity bookEnt = bookRepository.save(bookMapper.dtoToEntity(tUpdate));
        return bookMapper.entityToDto(bookEnt);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
