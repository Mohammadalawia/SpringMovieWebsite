package com.movie.movieApp.configuration;

import com.movie.movieApp.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    CommandLineRunner commandLineRunner(){
    return args -> {
        new Movie(12l, "Inception", "Sci-Fi", 148, "Christopher Nolan"
        );
    };
    }
}
