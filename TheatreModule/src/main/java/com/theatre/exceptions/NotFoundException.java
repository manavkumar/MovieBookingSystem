package com.theatre.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String showNotFound) {
        super(showNotFound);
    }
}
