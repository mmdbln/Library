package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.model.dto.BookDTO;
import com.mapsa.library.services.BookService;
import com.mapsa.library.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Books")
public class BookController extends BaseController<BookDTO> {
    @Autowired
    BookService bookService;

    public BookController(BaseService<BookDTO> baseService) {
        super(baseService);
    }

    @GetMapping("/{title}")
    public BookDTO getBookByTitle(@PathVariable String title) throws NotFoundException {
        return bookService.findBookByTitle(title).orElseThrow(NotFoundException::new);
    }
}
