package com.judyprograms.temperthestorm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

//    @GetMapping(value = "/tasks")
//    public ResponseEntity<Object> getAllTasks() {
//        return ResponseEntity.ok().body("get all tasks");
//    }

    @GetMapping(value = "/tasks")
    public String getAllTasks() {
//        {tasks: [{}, ...]}
        return "get all tasks";
    }

    @GetMapping(value = "/tasks/{taskName}")
    public String getTask(@PathVariable String taskName) {
//        {taskName: string, badge: string, subtasks: {string: [], ...}}
        return "get task:" + taskName;
    }
}
