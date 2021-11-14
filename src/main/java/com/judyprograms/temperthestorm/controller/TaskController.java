package com.judyprograms.temperthestorm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/tasks")
    public String getAllTasks() {
        return "all existing tasks";
    }

    @PatchMapping("/tasks?taskName={taskName}")
    public String modifyTask(@RequestParam String taskName) {
        return taskName + " modified";
    }

    @GetMapping("/tasks?taskName={taskName}")
    public String getTask(@RequestParam String taskName) {
        return "task info for: " + taskName;
    }

    @GetMapping("/subtasks?taskName={taskName}")
    public String getTaskSubtasks(@RequestParam String taskName) {
        return "subtasks for" + taskName;
    }


}
