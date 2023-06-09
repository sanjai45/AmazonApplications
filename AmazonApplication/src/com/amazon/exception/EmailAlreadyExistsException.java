package com.amazon.exception;

/**
 * <p>
 * Using email already exists exception
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class EmailAlreadyExistsException extends CustomException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
