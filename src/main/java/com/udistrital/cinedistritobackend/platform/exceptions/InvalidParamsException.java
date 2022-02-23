package com.udistrital.cinedistritobackend.platform.exceptions;

import java.util.Optional;

public class InvalidParamsException extends ApiException{
    private static final long serialVersionUID = 1L;

    public InvalidParamsException() {
        super("InvalidParamsException", "Invalid query", 400);
    }

    public InvalidParamsException(String message) {
        super("InvalidParamsException", message, 400);
    }
}
