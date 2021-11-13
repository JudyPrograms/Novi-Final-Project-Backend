package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.model.Player;
import com.judyprograms.temperthestorm.model.User;
import com.judyprograms.temperthestorm.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable long id) {
        return ResponseEntity.ok().body(playerService.getPlayer(id));
    }

    @PostMapping("/players")
    public ResponseEntity<?> createPlayer(@PathVariable long userId) {
    String newPlayer = playerService.createPlayer(userId);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(newPlayer)
                .toUri();

        return ResponseEntity.created(location).build();
    }

        @PutMapping("/players/{id")
    public ResponseEntity<?> updateNewPlayer(@PathVariable long id, @RequestBody Player player) {
        return ResponseEntity.ok().body("player initialized");
    }
}
