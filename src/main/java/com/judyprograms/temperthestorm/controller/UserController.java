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
//@PostMapping("/employees")
//Employee newEmployee(@RequestBody Employee newEmployee) {
//    return repository.save(newEmployee);
//}



    @PutMapping("/users/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/users/{username}/password")
    public ResponseEntity<?> setPassword(@PathVariable String username, @RequestBody String password) {
        userService.setPassword(username, password);
        return ResponseEntity.noContent().build();
    }



//      ENDPOINTS VOOR PLAYER CONTROLLER
//    @GetMapping("/users/{id}/{progress}")
//    public String getUserProgress(@PathVariable int id) {
//        return "user progress object for user" + id;
//    }
//
//    @PutMapping("/users/{id}/{progress}")
//    public String updateUserProgress(@PathVariable int id) {
//        return "user progress updated for user" + id;
//    }
//
//    @GetMapping("/users/{id}/current-tasks")
//    public String getUserCurrentTasks(@PathVariable int id) {
//        return "current tasks object for user" + id;
//    }
//
//    @PutMapping("/users/{id}/current-tasks")
//    public String updateUserCurrentTasks(@PathVariable int id) {
//        return "current tasks object for user" + id;
//    }
//
//    @GetMapping("/users/{id}/completed-tasks")
//    public String getUserCompletedTasks(@PathVariable int id) {
//        return "completed tasks object for user" + id;
//    }
//
//    @PutMapping("/users/{id}/completed-tasks")
//    public String updateUserCompletedTasks(@PathVariable int id) {
//        return "completed tasks object for user" + id;
//    }
}
