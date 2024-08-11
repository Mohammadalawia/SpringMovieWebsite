package com.movie.movieApp.controller;

import com.movie.movieApp.dto.DirectorDTO;
import com.movie.movieApp.model.Director;
import com.movie.movieApp.model.Movie;
import com.movie.movieApp.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/")

public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors") // get directors

    public List<DirectorDTO> GetDirectors() {
        return directorService.getDirectors();
    }

    @PostMapping("/directors") // post director
    public void PostDirector(@RequestBody Director director){
        directorService.saveDirectors(director);

    }
}
