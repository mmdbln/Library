package com.mapsa.library.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("resource not found");
    }
}
