package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.exception.NotFoundException;
import cz.gopas.eshopweb.pojo.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppRestControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<Message> handleNFE(NotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Message(e.getMessage()));
    }

}
