package com.judyprograms.temperthestorm.repository;

import com.judyprograms.temperthestorm.model.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SliceRepository extends JpaRepository<Slice, Long> {
    Optional<Slice> findBySliceNumber(Long sliceNumber);
}
