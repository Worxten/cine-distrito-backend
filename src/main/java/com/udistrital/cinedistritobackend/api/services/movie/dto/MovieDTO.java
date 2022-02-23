package com.udistrital.cinedistritobackend.api.services.movie.dto;

import com.udistrital.cinedistritobackend.api.controllers.movie.payloads.MoviePayload;
import com.udistrital.cinedistritobackend.api.services.movie.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private long id;
    private String nombre;
    private boolean status;
    private int lengthMinutes;
    private String director;
    private String classification;

    public static MovieDTO entityToDto(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getNombre(),
                movie.isStatus(),
                movie.getLengthMinutes(),
                movie.getDirector(),
                movie.getClassification());
    }

    public static MovieDTO payloadToDto(MoviePayload movie) {
        return new MovieDTO(
                0,
                movie.getNombre(),
                movie.isStatus(),
                movie.getLengthMinutes(),
                movie.getDirector(),
                movie.getClassification());
    }

    public static ArrayList<MovieDTO> entitiesToDtos(ArrayList<Movie> movies) {
        ArrayList<MovieDTO> movieDTOS = new ArrayList<>();
        for (Movie movie : movies) {
            movieDTOS.add(MovieDTO.entityToDto(movie));
        }
        return movieDTOS;
    }

    public static ArrayList<MovieDTO> payloadsToDtos(ArrayList<MoviePayload> movies) {
        ArrayList<MovieDTO> movieDTOS = new ArrayList<>();
        for (MoviePayload movie : movies) {
            movieDTOS.add(MovieDTO.payloadToDto(movie));
        }
        return movieDTOS;
    }

}
