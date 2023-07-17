package com.booking.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String showNotFound) {
        super(showNotFound);
    }
}
