package com.movie.movieApp.dto;

import java.util.List;

public class ActorDTO {

    private String name;
    private String birthdate;
    private List<String> movieNames;


    public ActorDTO(String name, String birthdate,List<String> movieNames) {
        this.name = name;
        this.birthdate = birthdate;
        this.movieNames = movieNames;
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
    public List<String> getMovieNames() {
        return movieNames;
    }

    public void setMovieNames(List<String> movieNames) {
        this.movieNames = movieNames;
    }
}
