package com.judyprograms.temperthestorm.exception;

public class UserNotFoundException extends RuntimeException {
//    public UserNotFoundException() {
//        super("User not found.");
//    }
    public UserNotFoundException(String username) {
        super("Cannot find user " + username);
    }
}
