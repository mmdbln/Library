package com.mapsa.library.repositories;

import com.mapsa.library.model.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E ,Long> {
}
