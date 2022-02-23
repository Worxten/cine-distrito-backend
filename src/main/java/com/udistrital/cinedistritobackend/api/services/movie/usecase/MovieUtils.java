package com.udistrital.cinedistritobackend.api.services.movie.usecase;

import com.udistrital.cinedistritobackend.api.controllers.movie.payloads.MoviePayload;

public class MovieUtils {
    public static boolean validateMoviePayload(MoviePayload moviePayload) {
        if (moviePayload.getNombre().equals("") || moviePayload.getNombre() == null)
            return false;
        if (moviePayload.getDirector().equals("") || moviePayload.getDirector() == null)
            return false;
        if (moviePayload.getLengthMinutes() == 0)
            return false;
        if (moviePayload.getClassification().equals("") || moviePayload.getClassification() == null)
            return false;
        return true;
    }
}
