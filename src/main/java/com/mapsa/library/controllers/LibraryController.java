package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.mapper.LibraryMapper;
import com.mapsa.library.model.domain.LibrarianEntity;
import com.mapsa.library.model.domain.LibraryEntity;
import com.mapsa.library.model.dto.LibraryDTO;
import com.mapsa.library.repositories.LibraryRepository;
import com.mapsa.library.services.LibraryService;
import com.mapsa.library.services.BaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController extends BaseController<LibraryDTO, LibraryEntity, LibraryMapper, LibraryRepository,LibraryService> {

    public LibraryController(LibraryService service) {
        super(service);
    }

    @GetMapping("/{name}")
    public LibraryDTO getLibraryByName(@PathVariable String name) throws NotFoundException {
        return service.getLibraryByName(name).orElseThrow(NotFoundException::new);
    }


}
