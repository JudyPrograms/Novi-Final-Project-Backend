package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.exception.InvalidPasswordException;
import com.judyprograms.temperthestorm.exception.NotUniqueException;
import com.judyprograms.temperthestorm.exception.RecordNotFoundException;
import com.judyprograms.temperthestorm.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String recordNotFoundException(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundException(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(value = NotUniqueException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String notUniqueException(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(value = InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String invalidPasswordException(Exception exception) {
        return exception.getMessage();
    }


//    @ExceptionHandler(value = NotAuthorizedException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public String notAuthorizedException(Exception exception) {
//        return exception.getMessage();
//    }


//    @ExceptionHandler(value = BadRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String badRequestException(Exception exception) {
//        return exception.getMessage();
//    }
}
