package com.movie.movieApp.controller;

import com.movie.movieApp.model.Movie;
import com.movie.movieApp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/movies")

    public List<Movie> GetMovies(){
        return movieService.getMovies();
    }

    @GetMapping("/")
    public String Home(){
        return "help this page is empty";
    }

}
