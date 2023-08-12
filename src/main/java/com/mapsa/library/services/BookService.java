package com.mapsa.library.services;

import com.mapsa.library.mapper.BookMapper;
import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.dto.BookDTO;
import com.mapsa.library.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService extends BaseService<BookDTO, BookEntity, BookMapper, BookRepository> {

    public BookService(BookMapper mapper, BookRepository repository) {
        super(mapper, repository);
    }

    public Optional<BookDTO> findBookByTitle(String title){
        BookEntity targetName = repository.findAll()
                .stream()
                .filter(item -> item.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(mapper.entityToDto(targetName));
    }
}
