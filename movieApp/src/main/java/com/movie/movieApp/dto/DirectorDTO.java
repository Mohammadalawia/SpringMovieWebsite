package com.movie.movieApp.dto;

import com.movie.movieApp.model.Movie;

import java.util.List;

public class DirectorDTO {
    private String name;
    private String birthdate;
    private List<MovieDTO> movies;

    public DirectorDTO(String name, String birthdate, List<MovieDTO> movies) {
        this.name = name;
        this.birthdate = birthdate;
        this.movies = movies;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }


}
