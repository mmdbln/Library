package com.mapsa.library.services;

import com.mapsa.library.mapper.BorrowMapper;
import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.dto.BorrowDTO;
import com.mapsa.library.repositories.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowService  {
    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;



}
