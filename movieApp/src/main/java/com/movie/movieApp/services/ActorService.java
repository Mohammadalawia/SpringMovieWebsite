package com.movie.movieApp.services;

import com.movie.movieApp.dto.ActorDTO;
import com.movie.movieApp.model.Actor;
import com.movie.movieApp.model.Movie;
import com.movie.movieApp.repository.ActorRepository;
import com.movie.movieApp.dto.ActorMapper; // Import the ActorMapper interface
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<ActorDTO> getActors() {
        return actorRepository.findAll().stream()
                .map(actor -> {
                    // Assuming you have a method to fetch movie names from an actor
                    List<String> movieNames = actor.getMovies().stream()
                            .map(Movie::getTitle) // Change 'getTitle' if the method differs
                            .collect(Collectors.toList());

                    return ActorMapper.INSTANCE.actorToActorDTO(actor, movieNames);
                })
                .collect(Collectors.toList());
    }

    public void saveActors(Actor actor) {
        Optional<Actor> actorOptional =
                actorRepository.findActorByName(actor.getName());
        if (actorOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        actorRepository.save(actor);
    }

    public Optional<Actor> getOneActor(Long actorId) {
        Optional<Actor> actorOptional = actorRepository.findById(actorId);
        if (actorOptional.isPresent()) {
            return actorRepository.findById(actorId);
        } else {
            throw new IllegalStateException("no such Id");
        }
    }
}
