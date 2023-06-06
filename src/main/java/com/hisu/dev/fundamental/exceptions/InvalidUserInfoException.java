package com.hisu.dev.fundamental.exceptions;

public class InvalidUserInfoException extends RuntimeException {
    public InvalidUserInfoException(String message) {
        super(message);
    }
    public InvalidUserInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
