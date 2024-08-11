package com.movie.movieApp.repository;

import com.movie.movieApp.model.Genre;
import com.movie.movieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query("SELECT s FROM Movie s WHERE s.title = ?1")
    Optional<Movie> findMovieByTitle(String title);

    @Query("SELECT s FROM Movie s WHERE s.grossIncome > :amount")
    Optional<Movie> findLargeGross(@Param("amount") Integer amount);

    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.genre")
    List<Movie> findAllMoviesWithGenres();
}
