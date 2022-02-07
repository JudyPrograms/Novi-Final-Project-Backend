package com.judyprograms.temperthestorm.exception;

public class NotUniqueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotUniqueException() {
        super("Unique data required.");
    }

    public NotUniqueException(String text) {
        super(text);
    }
}
