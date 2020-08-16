package com.example.PashaWeb.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String id) {
        super("Could not find entity " + id);
    }
}
