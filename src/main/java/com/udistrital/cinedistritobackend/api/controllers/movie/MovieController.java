package com.udistrital.cinedistritobackend.api.controllers.movie;

import com.udistrital.cinedistritobackend.api.controllers.movie.payloads.MoviePayload;
import com.udistrital.cinedistritobackend.api.services.movie.usecase.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    public final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllMovies(){
        return new ResponseEntity(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMovie(@PathVariable long id){
        return new ResponseEntity(movieService.getMovie(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createMovie(@RequestBody MoviePayload moviePayload){
        return new ResponseEntity(movieService.createMovie(moviePayload), HttpStatus.OK);
    }
}
