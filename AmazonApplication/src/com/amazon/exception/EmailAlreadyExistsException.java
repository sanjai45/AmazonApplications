package com.amazon.exception;

public class EmailAlreadyExistsException extends CustomException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
