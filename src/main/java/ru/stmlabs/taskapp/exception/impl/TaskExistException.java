package ru.stmlabs.taskapp.exception.impl;

public class TaskExistException extends RuntimeException {

    public TaskExistException(String message) {
        super(message);
    }
}
