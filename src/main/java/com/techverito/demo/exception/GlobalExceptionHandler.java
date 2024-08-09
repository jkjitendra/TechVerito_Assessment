package com.techverito.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(userAlreadyExistsException.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(resourceNotFoundException.getMessage());
    }
}
