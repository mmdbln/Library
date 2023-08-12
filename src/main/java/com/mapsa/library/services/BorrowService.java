package com.mapsa.library.services;

import com.mapsa.library.exceptions.BorrowedYetException;
import com.mapsa.library.exceptions.NotFoundException;
import com.mapsa.library.mapper.BorrowMapper;
import com.mapsa.library.model.domain.BookEntity;
import com.mapsa.library.model.domain.BorrowEntity;
import com.mapsa.library.model.dto.BorrowDTO;
import com.mapsa.library.repositories.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowService extends BaseService<BorrowDTO,BorrowEntity,BorrowMapper,BorrowRepository>  {
    public BorrowService(BorrowMapper mapper, BorrowRepository repository) {
        super(mapper, repository);
    }

    @Override
    public BorrowDTO create(BorrowDTO borrowDTO) throws BorrowedYetException {
        if (!borrowDTO.getBookEntity().getIsBorrowed()) {
            BorrowEntity ent = repository.save(mapper.dtoToEntity(borrowDTO));
            borrowDTO.getBookEntity().setIsBorrowed(true);
            return mapper.entityToDto(ent);
        }
        throw new BorrowedYetException();
    }

    @Override
    public BorrowDTO update(BorrowDTO tUpdate) throws BorrowedYetException {
        if (!tUpdate.getBookEntity().getIsBorrowed()) {
            BorrowEntity entity = repository.save(mapper.dtoToEntity(tUpdate));
            return mapper.entityToDto(entity);
        }
        throw new BorrowedYetException();
    }

    @Override
    public Boolean deleteById(Long id) {
        BorrowEntity entity = repository.findAll()
                .stream()
                .filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if (entity == null || entity.getIsDeleted())
            return false;
        entity.setIsDeleted(true);
        entity.getBookEntity().setIsBorrowed(false);
        return true;
    }
}
