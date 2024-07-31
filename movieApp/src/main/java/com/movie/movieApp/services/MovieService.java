package com.movie.movieApp.services;

import com.movie.movieApp.model.Movie;
import com.movie.movieApp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final StudentRepository studentRepository;

    public MovieService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Movie> getMovies(){
        return studentRepository.findAll();
    }
}