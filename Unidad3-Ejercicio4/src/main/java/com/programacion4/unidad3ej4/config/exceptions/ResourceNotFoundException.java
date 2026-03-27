package com.programacion4.unidad3ej4.config.exceptions;

import java.util.List;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends CustomException {

    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, List.of(message));
    }
}
