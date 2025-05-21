package com.example.biblioteca.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object response) {
        Map<String, Object> body = new HashMap<>();

        body.put("message", message);
        body.put("status", status.value());
        body.put("response", response);

        return new ResponseEntity<>(body, status);
    }
}