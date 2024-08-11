package com.movie.movieApp.repository;

import com.movie.movieApp.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {


    @Query("SELECT n FROM Studio n WHERE n.name = ?1")
    Optional<Studio> findStudioByName(String name);
}
