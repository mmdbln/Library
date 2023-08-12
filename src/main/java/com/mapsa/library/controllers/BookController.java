package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.mapper.BookMapper;
import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.dto.BookDTO;
import com.mapsa.library.repositories.BookRepository;
import com.mapsa.library.services.BookService;
import com.mapsa.library.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Books")
public class BookController extends BaseController<BookDTO, BookEntity, BookMapper, BookRepository,BookService> {
    public BookController(BookService service) {
        super(service);
    }

    @GetMapping("/{title}")
    public BookDTO getBookByTitle(@PathVariable String title) throws NotFoundException {
        return service.findBookByTitle(title).orElseThrow(NotFoundException::new);
    }
}
