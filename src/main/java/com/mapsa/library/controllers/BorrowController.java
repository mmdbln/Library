package com.mapsa.library.controllers;

import com.mapsa.library.model.dto.BorrowDTO;
import com.mapsa.library.services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
public class BorrowController extends BaseController<BorrowDTO> {
    public BorrowController(BaseService<BorrowDTO> baseService) {
        super(baseService);
    }


}
