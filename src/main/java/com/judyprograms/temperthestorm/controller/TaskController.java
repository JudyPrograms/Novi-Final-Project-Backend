package com.judyprograms.temperthestorm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

//    @GetMapping("/books/{id}")
//    public ResponseEntity<Object> getBook(@PathVariable long id) {
//        return ResponseEntity.ok(...);
//    }

//    @PostMapping("/books")
//    public ResponseEntity<Object> addBook(@RequestBody String title) {
//    ...
//        return ResponseEntity.created(...);
//    }


    @GetMapping("/tasks")
    public String getAllTasks() {
//        {tasks: [{}, ...]}
        return "all existing tasks";
    }

    @PatchMapping("/tasks?taskName={taskName}")
    public String modifyTask(@RequestParam String taskName) {
//        {tasks: [{}, ...]}
        return taskName + " modified";
    }

    @GetMapping("/tasks?taskName={taskName}")
    public String getTask(@RequestParam String taskName) {
//        {taskName: string,
//        badge: string,
//        subtasks: {string: [], ...}}
        return "task info for: " + taskName;
    }

    @GetMapping("/subtasks?taskName={taskName}")
    public String getTaskSubtasks(@RequestParam String taskName) {
//        {string: [string, ...],
//        string: [string, ...],
//        ...}
        return "subtasks for" + taskName;
    }


}
