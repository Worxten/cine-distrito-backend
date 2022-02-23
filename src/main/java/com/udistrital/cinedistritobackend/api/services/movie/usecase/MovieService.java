package com.udistrital.cinedistritobackend.api.services.movie.usecase;

import com.udistrital.cinedistritobackend.api.infrastructure.movie.repository.IMovieRepository;
import com.udistrital.cinedistritobackend.api.services.movie.dto.MovieDTO;
import com.udistrital.cinedistritobackend.api.services.movie.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    private IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ArrayList<MovieDTO> getAllMovies() {
        ArrayList <Movie> movies = (ArrayList<Movie>) movieRepository.findAll();
        return MovieDTO.entitiesToDtos(movies);
    }

    public MovieDTO getMovie(long id) {
         Movie movie = movieRepository.findMovieById(id);
         MovieDTO movieResponse;
         if (movie == null){
             movieResponse = new MovieDTO();
         }else {
             movieResponse = MovieDTO.entityToDto(movie);
         }
        return movieResponse;
    }
}
