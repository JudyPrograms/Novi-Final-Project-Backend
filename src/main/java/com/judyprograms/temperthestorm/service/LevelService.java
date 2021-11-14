package com.judyprograms.temperthestorm.service;

import com.judyprograms.temperthestorm.model.Level;
import com.judyprograms.temperthestorm.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LevelService {

    @Autowired
    private LevelRepository levelRepository;

    public Iterable<Level> getLevels() {
        return levelRepository.findAll();
    }

    public Optional<Level> getLevel(Long levelNumber) {
        return levelRepository.findByLevelNumber(levelNumber);
    }
}
