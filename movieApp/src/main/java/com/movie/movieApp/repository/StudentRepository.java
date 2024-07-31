package com.movie.movieApp.repository;

import com.movie.movieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Movie, Long> {

}
