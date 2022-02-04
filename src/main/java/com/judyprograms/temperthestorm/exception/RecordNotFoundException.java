package com.judyprograms.temperthestorm.exception;

public class RecordNotFoundException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public RecordNotFoundException() {
        super("Record not found.");
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}


