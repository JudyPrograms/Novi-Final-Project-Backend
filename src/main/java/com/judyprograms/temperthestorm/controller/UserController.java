package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.model.Person;
import com.judyprograms.temperthestorm.exception.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    //    @GetMapping("/books/{id}")
    //    public ResponseEntity<Object> getBook(@PathVariable long id) {
    //        return ResponseEntity.ok(...);
    //    }

    //    @PostMapping("/books")
    //    public ResponseEntity<Object> addBook(@RequestBody String title) {
    //    ...
    //        return ResponseEntity.created(...);
    //    }

    //    @DeleteMapping("/books/{id}")
    //    public ResponseEntity<Object> deleteBook(@PathVariable int id) {
    //    ...
    //        return ResponseEntity.noContent();
    //    }

    //    @PutMapping("/books/{id}")
    //    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody String title) {
    //    ...
    //        return ResponseEntity.noContent();
    //    }

    //    @PatchMapping("/books/{id}")
    //    public ResponseEntity<Object> modifyBook(@PathVariable int id, @RequestBody String title) {
    //    ...
    //        return ResponseEntity.noContent();
    //    }

    private static List<Person> people = new ArrayList<>();


    @GetMapping("/users")
    public ResponseEntity getAllUsers(@RequestParam(required = false) String username) {
//        {users : [{}, ...]}
        if (username == null) {
            return ResponseEntity.ok(people);
        } else {
//            search in Arraylist with username:
            return ResponseEntity.ok(
                    people
                            .stream()
                            .filter(person -> person.username.equalsIgnoreCase(username))
                            .toArray());
        }
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody Person person) {
        people.add(person);
//        {username: string,
//        email: string,
//        password: string
//        avatarName: "anonymous"
//        avatarImg: blanco-avatar}
        return ResponseEntity.ok("user " + person + " added");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        //        {username: string,
//        email: string,
//        password: string,
//        avatarName: string,
//        avatarImg: file}
        try {
            return ResponseEntity.ok(people.get(id));
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        people.remove(id);
        return ResponseEntity.ok("user" + id + " removed");
    }

    @PutMapping("/users/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody Person person) {
        people.set(id, person);
        return ResponseEntity.ok("user" + id + " updated");
    }


    @PatchMapping("/users/{id}")
//    public ResponseEntity<Object> modifyUser(@PathVariable String id @RequestBody String avatarName) {
    public String modifyUser(@PathVariable String id) {
//        {username: string,
//        email: string,
//        password: string}
//        avatarName: string,
//        avatarImg:  file}
        return "user info modified for user" + id;
    }


    @GetMapping("/users/{id}/{progress}")
    public String getUserProgress(@PathVariable int id) {
//        {badgeProgress: {paperwork: int, ...},
//        level: string,
//        coinsTotal: int,
//        leaderboardPosition: int}
        return "user progress object for user" + id;
    }

    @PutMapping("/users/{id}/{progress}")
//    public String updateUserProgress(@PathVariable long id) {
    public String updateUserProgress(@PathVariable int id) {
//        {badgeProgress: {paperwork: int, ...},
//        level: string,
//        coinsTotal: int,
//        leaderboardPosition: int}
        return "user progress updated for user" + id;
    }

    @GetMapping("/users/{id}/current-tasks")
    public String getUserCurrentTasks(@PathVariable int id) {
//        {mainTask: string,
//        subtask: string,
//        slice: string,
//        startDate: datetime}
        return "current tasks object for user" + id;
    }

    @PutMapping("/users/{id}/current-tasks")
    public String updateUserCurrentTasks(@PathVariable int id) {
//        {mainTask: string,
//        subtask: string,
//        slice: string,
//        startDate: datetime}
        return "current tasks object for user" + id;
    }

    @GetMapping("/users/{id}/completed-tasks")
    public String getUserCompletedTasks(@PathVariable int id) {
//       {mainTask: string,
//       subtask: string,
//       slice: string,
//       finishDate: datetime}
        return "completed tasks object for user" + id;
    }

    @PutMapping("/users/{id}/completed-tasks")
    public String updateUserCompletedTasks(@PathVariable int id) {
//       {mainTask: string,
//       subtask: string,
//       slice: string,
//       finishDate: datetime}
        return "completed tasks object for user" + id;
    }
}
