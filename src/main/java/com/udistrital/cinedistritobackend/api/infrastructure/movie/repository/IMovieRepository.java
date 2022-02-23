package com.udistrital.cinedistritobackend.api.infrastructure.movie.repository;

import com.udistrital.cinedistritobackend.api.services.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    ArrayList<Movie> getAllById(long id);
    Movie findMovieById(long id);

}
