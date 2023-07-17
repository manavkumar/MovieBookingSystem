package com.theatre.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String invalidEmailOrPassword) {
        super(invalidEmailOrPassword);
    }
}
