package com.judyprograms.temperthestorm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/users")
    public String getAllUsers() {
        return "get users";
    }

    @GetMapping(value = "/users/{id}")
    public String getUser(@PathVariable long id) {
//        username,
//        email,
//        password,
//        avatarName,
//        avatarImg,
        return "get user" + id;
    }

    @GetMapping(value = "/users/{id}/progress")
    public String getUserProgress(@PathVariable long id) {
//        badgeProgress: {string: int, ...}
//        level, string
//        coinsTotal, int
//        leaderboardPosition, int
        return "get user" + id;
    }

    @GetMapping(value = "/users/{id}/current-tasks")
    public String getUserCurrentTasks(@PathVariable long id) {
//      array of subtask objects: {mainTask, subtask, slice, startDate}
        return "get current tasks of user" + id;
    }

    @GetMapping(value = "/users/{id}/completed-tasks")
    public String getUserCompletedTasks(@PathVariable long id) {
        //        array of subtask objects: {mainTask, subtask, slice, finishDate}
        return "get completed tasks of user" + id;
    }
}
