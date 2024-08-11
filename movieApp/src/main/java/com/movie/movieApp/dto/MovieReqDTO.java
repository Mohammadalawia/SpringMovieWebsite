package com.movie.movieApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.movieApp.model.Genre;

import java.util.List;

public class MovieReqDTO {
    private Long id;
    private String title;
    private List<Genre> genre;
    private int duration;
    private Integer grossIncome;

    @JsonProperty("director_id")
    private Long directorId;

    @JsonProperty("studio_id")
    private Long studioId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Integer getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Integer grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Long getStudioId() {
        return studioId;
    }

    public void setStudioId(Long studioId) {
        this.studioId = studioId;
    }
}
