package com.udistrital.cinedistritobackend.api.services.movie.entity;

import com.udistrital.cinedistritobackend.api.services.movie.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private int lengthMinutes;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String classification;

    public static Movie dtoToEntity(MovieDTO movie){
        return new Movie(
                movie.getId(),
                movie.getNombre(),
                movie.isStatus(),
                movie.getLengthMinutes(),
                movie.getDirector(),
                movie.getClassification());
    }
}
