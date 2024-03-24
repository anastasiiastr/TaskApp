package ru.stmlabs.taskapp.exception.controller;

import ru.stmlabs.taskapp.exception.entity.Error;
import ru.stmlabs.taskapp.exception.impl.AccessDeniedException;
import ru.stmlabs.taskapp.exception.impl.TaskExistException;
import ru.stmlabs.taskapp.exception.impl.UserExistException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public Error handleMethodArgumentTypeMismatchException(final AccessDeniedException exception) {
        return Error.builder()
                .status(BAD_REQUEST.getReasonPhrase().toUpperCase())
                .reason("ACCESS DENIED")
                .message(exception.getMessage())
                .timestamp(now())
                .build();
    }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public Error handleMethodArgumentTypeMismatchException(final TaskExistException exception) {
        return Error.builder()
                .status(BAD_REQUEST.getReasonPhrase().toUpperCase())
                .reason("EXIST EXCEPTION")
                .message(exception.getMessage())
                .timestamp(now())
                .build();
    }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public Error handleMethodArgumentTypeMismatchException(final UserExistException exception) {
        return Error.builder()
                .status(BAD_REQUEST.getReasonPhrase().toUpperCase())
                .reason("EXIST EXCEPTION")
                .message(exception.getMessage())
                .timestamp(now())
                .build();
    }
}
