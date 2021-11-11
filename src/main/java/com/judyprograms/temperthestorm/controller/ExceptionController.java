package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String recordNotFoundException(Exception exception) {
        return exception.getMessage();
    }

//    #### VOORBEELD UIT DE LES:
//    @ExceptionHandler(value = RecordNotFoundException.class)
//    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
//        return ResponseEntity.notFound().build();
//    }
//    #### EINDE


//    @ExceptionHandler(value = NotAuthorizedException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public String notAuthorizedException(Exception exception) {
//        return exception.getMessage();
//    }
//
//    @ExceptionHandler(value = InvalidPasswordException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public String invalidPasswordException(Exception exception) {
//        return exception.getMessage();
//    }
//
//    @ExceptionHandler(value = UserNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String userNotFoundException(Exception exception) {
//        return exception.getMessage();
//    }
//
//    @ExceptionHandler(value = BadRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String badRequestException(Exception exception) {
//        return exception.getMessage();
//    }
}
