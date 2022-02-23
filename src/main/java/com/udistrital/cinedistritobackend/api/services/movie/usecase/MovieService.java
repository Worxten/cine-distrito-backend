package com.udistrital.cinedistritobackend.api.services.movie.usecase;

import com.udistrital.cinedistritobackend.api.controllers.movie.payloads.MoviePayload;
import com.udistrital.cinedistritobackend.api.infrastructure.movie.repository.IMovieRepository;
import com.udistrital.cinedistritobackend.api.services.movie.dto.MovieDTO;
import com.udistrital.cinedistritobackend.api.services.movie.entity.Movie;
import com.udistrital.cinedistritobackend.platform.exceptions.api.InvalidParamsException;
import com.udistrital.cinedistritobackend.platform.exceptions.movie.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    private IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ArrayList<MovieDTO> getAllMovies() {
        ArrayList<Movie> movies = (ArrayList<Movie>) movieRepository.findAll();
        return MovieDTO.entitiesToDtos(movies);
    }

    public MovieDTO getMovie(long id) {
        Movie movie = movieRepository.findMovieById(id);
        MovieDTO movieResponse;
        if (movie == null)
            throw new MovieNotFoundException(Long.toString(id));
        else
            movieResponse = MovieDTO.entityToDto(movie);

        return movieResponse;
    }

    public MovieDTO createMovie(MoviePayload moviePayload) {
        if (!MovieUtils.validateMoviePayload(moviePayload))
            throw new InvalidParamsException();
        MovieDTO movieDTO = MovieDTO.payloadToDto(moviePayload);
        Movie movie = Movie.dtoToEntity(movieDTO);
        movieRepository.save(movie);
        return movieDTO;
    }


}
