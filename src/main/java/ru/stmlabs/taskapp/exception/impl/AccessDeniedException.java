package ru.stmlabs.taskapp.exception.impl;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String message) {
        super(message);
    }
}
