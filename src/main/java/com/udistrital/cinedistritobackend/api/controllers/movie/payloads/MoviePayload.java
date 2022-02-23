package com.udistrital.cinedistritobackend.api.controllers.movie.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.udistrital.cinedistritobackend.api.services.movie.dto.MovieDTO;
import com.udistrital.cinedistritobackend.api.services.movie.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviePayload {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("status")
    private boolean status;
    @JsonProperty("length_minutes")
    private int lengthMinutes;
    @JsonProperty("director")
    private String director;
    @JsonProperty("classification")
    private String classification;


    public static MoviePayload dtoToPayload(MovieDTO movie) {
        return new MoviePayload(
                movie.getNombre(),
                movie.isStatus(),
                movie.getLengthMinutes(),
                movie.getDirector(),
                movie.getClassification());
    }

    public static ArrayList<MoviePayload> dtosToPayloads(ArrayList<MovieDTO> movies) {
        ArrayList<MoviePayload> moviesPayload = new ArrayList<>();
        for (MovieDTO movie : movies) {
            moviesPayload.add(MoviePayload.dtoToPayload(movie));
        }
        return moviesPayload;
    }

}
