package com.judyprograms.temperthestorm.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Invalid password.");
    }
    public InvalidPasswordException(String message) {
        super(message);
    }
}
