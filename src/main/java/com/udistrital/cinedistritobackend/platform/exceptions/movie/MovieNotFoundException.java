package com.udistrital.cinedistritobackend.platform.exceptions.movie;

import com.udistrital.cinedistritobackend.platform.exceptions.api.ApiException;

public class MovieNotFoundException extends ApiException {
    private static final long serialVersionUID = 1L;
    public MovieNotFoundException(String msj) {
        super("MovieNotFoundException", "Movie " + msj + " was not found.", 404);
    }
}
