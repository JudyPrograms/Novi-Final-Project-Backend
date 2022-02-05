package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.dto.UserRequestDto;
import com.judyprograms.temperthestorm.model.Player;
import com.judyprograms.temperthestorm.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping("/players")
    public ResponseEntity<Object> getPlayers() {
        return ResponseEntity.ok().body(playerService.getPlayers());
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok().body(playerService.getPlayer(id));
    }

    @PostMapping("/players/{id}")
    public ResponseEntity<Object> createPlayer(@PathVariable Long id) {

        Long newPlayerId = playerService.createPlayer(id);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPlayerId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<Object> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        playerService.updatePlayer(id, player);
        return ResponseEntity.noContent().build();
    }
}
