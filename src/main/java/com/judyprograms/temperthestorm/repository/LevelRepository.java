package com.judyprograms.temperthestorm.repository;

import com.judyprograms.temperthestorm.model.Level;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LevelRepository extends CrudRepository<Level, String> {

    Optional<Level> findByLevelNumber(Long levelNumber);
}
