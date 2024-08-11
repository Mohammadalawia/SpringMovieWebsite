package com.movie.movieApp.controller;

import com.movie.movieApp.dto.ActorDTO;
import com.movie.movieApp.model.Actor;
import com.movie.movieApp.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/")

public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {

        this.actorService = actorService;
    }

    @GetMapping("/actors") // get actors

    public List<ActorDTO> GetActors() {
        return actorService.getActors();
    }

    @PostMapping("/actors") // post actors
    public void PostActor(@RequestBody Actor actor){
        actorService.saveActors(actor);

    }
    @GetMapping("/actors/{actorId}")
    public Optional<Actor> GetActor(@PathVariable Long actorId){
        return actorService.getOneActor(actorId);
    }
}
