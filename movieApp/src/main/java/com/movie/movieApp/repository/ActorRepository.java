package com.movie.movieApp.repository;

import com.movie.movieApp.model.Actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {


    @Query("SELECT n FROM Actor n WHERE n.name = ?1")
    Optional<Actor> findActorByName(String name);
}
