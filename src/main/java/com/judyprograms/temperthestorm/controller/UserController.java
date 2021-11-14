package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.model.User;
import com.judyprograms.temperthestorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//@CrossOrigin(Origins ="http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

//    SIMPELE VERSIE:
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.createUser(user));
    }
//      UITGEBREIDE VERSIE:
//    @PostMapping("/users")
//    public ResponseEntity<Object> createUser(@RequestBody User user) {
////        DTO CLASS WERKT NOG NIET:
////    (@RequestBody @Valid UserRequestDto userRequestDto) {
//        String newUsername  = userService.createUser(user);
////        String newUsername = userService.createUser(userRequestDto);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{username}")
//                .buildAndExpand(newUsername)
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }


    @PutMapping("/users/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<?> removeUser(@PathVariable String username) {
        userService.removeUser(username);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/users/{username}/password")
    public ResponseEntity<?> setPassword(@PathVariable String username, @RequestBody String password) {
        userService.setPassword(username, password);
        return ResponseEntity.noContent().build();
    }

}
