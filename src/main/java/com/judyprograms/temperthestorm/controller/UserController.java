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
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {

        String newUsername = userService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<Object> removeUser(@PathVariable String username) {
        userService.removeUser(username);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/users/{username}")
    public ResponseEntity<Object> partialUpdateUser(@PathVariable String username, @RequestBody User user) {
        userService.partialUpdateUser(username, user);
        return ResponseEntity.noContent().build();
    }

}
