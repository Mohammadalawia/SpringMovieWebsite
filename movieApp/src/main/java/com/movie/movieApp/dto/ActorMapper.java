package com.movie.movieApp.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.movie.movieApp.model.Actor;
import java.util.List;

@Mapper
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    @Mapping(target = "movieNames", source = "movieNames")
    ActorDTO actorToActorDTO(Actor actor, List<String> movieNames);
}
