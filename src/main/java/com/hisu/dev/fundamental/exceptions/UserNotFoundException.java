package com.hisu.dev.fundamental.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("No user with id " + id);
    }
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}