package com.mapsa.library.repositories;

import com.mapsa.library.model.domain.BaseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRepository extends BaseRepository {
    @Override
    Optional<BaseEntity> findById(Long aLong);

}
