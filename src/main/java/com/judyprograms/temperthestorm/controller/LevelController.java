package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class LevelController {

    @Autowired
    private LevelService levelService;

    @GetMapping("/levels")
    public ResponseEntity<?> getLevels() {
        return ResponseEntity.ok().body(levelService.getLevels());
    }

    @GetMapping("/levels/{levelNumber}")
    public ResponseEntity<?> getLevel(@PathVariable Long levelNumber) {
        return ResponseEntity.ok().body(levelService.getLevel(levelNumber));
    }

}
