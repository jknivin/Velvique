package com.pillow.pillow.Auth.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
