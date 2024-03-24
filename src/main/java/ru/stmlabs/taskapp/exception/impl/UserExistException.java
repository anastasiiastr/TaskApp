package ru.stmlabs.taskapp.exception.impl;

public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}
