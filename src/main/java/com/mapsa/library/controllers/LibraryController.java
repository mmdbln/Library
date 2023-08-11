package com.mapsa.library.controllers;

import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.model.dto.LibraryDTO;
import com.mapsa.library.services.LibraryService;
import com.mapsa.library.services.BaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController extends BaseController<LibraryDTO> {
    LibraryService libraryService;

    public LibraryController(BaseService<LibraryDTO> baseService) {
        super(baseService);
    }
    @GetMapping("/{name}")
    public LibraryDTO getLibraryByName(@PathVariable String name) throws NotFoundException {
        return libraryService.getLibraryByName(name).orElseThrow(NotFoundException::new);
    }


}
