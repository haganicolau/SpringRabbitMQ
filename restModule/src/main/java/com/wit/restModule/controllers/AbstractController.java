package com.wit.restModule.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController {

    public ResponseEntity<String> getBadRequestMessage(String message) {
        String stringConcat = String.format("{\"message\": \"%s\"}", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(stringConcat);
    }

    public ResponseEntity<String> getErrorRequestMessage(String message) {
        String stringConcat = String.format("{\"message\": \"%s\"}", message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(stringConcat);
    }
}
