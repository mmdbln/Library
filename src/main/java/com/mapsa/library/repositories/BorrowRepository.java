package com.mapsa.library.repositories;

import com.mapsa.library.model.domain.BaseEntity;
import com.mapsa.library.model.domain.BorrowEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRepository extends BaseRepository<BorrowEntity> {
    @Override
    Optional<BorrowEntity> findById(Long aLong);

}
