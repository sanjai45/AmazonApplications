package com.amazon.exception;

/**
 * <p>
 * Using custom exception
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class CustomException extends RuntimeException {
    public CustomException(final String message) {
        super(message);
    }
}

