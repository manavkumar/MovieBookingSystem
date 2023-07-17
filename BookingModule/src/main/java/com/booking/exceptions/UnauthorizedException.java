package com.booking.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String invalidEmailOrPassword) {
        super(invalidEmailOrPassword);
    }
}
