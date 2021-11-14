package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.model.Player;
import com.judyprograms.temperthestorm.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping("/players/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok().body(playerService.getPlayer(id));
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return ResponseEntity.ok().body(playerService.updatePlayer(id, player));
    }
}
