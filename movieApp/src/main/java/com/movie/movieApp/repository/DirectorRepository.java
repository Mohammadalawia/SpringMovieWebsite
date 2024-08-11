package com.movie.movieApp.repository;

import com.movie.movieApp.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {


    @Query("SELECT n FROM Director n WHERE n.name = ?1")
    Optional<Director> findDirectorByName(String name);
}
