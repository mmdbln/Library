package com.mapsa.library.controllers;

import com.mapsa.library.mapper.BorrowMapper;
import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.dto.BorrowDTO;
import com.mapsa.library.repositories.BorrowRepository;
import com.mapsa.library.services.BaseService;
import com.mapsa.library.services.BookService;
import com.mapsa.library.services.BorrowService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
public class BorrowController extends BaseController<BorrowDTO, BorrowEntity, BorrowMapper, BorrowRepository, BorrowService> {
    public BorrowController(BorrowService service) {
        super(service);
    }
}
