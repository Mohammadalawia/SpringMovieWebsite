package com.movie.movieApp.dto;

import com.movie.movieApp.model.Director;
import com.movie.movieApp.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);
    @Mapping(target = "movies", source = "movies", qualifiedByName = "mapMoviesToMovieDTOs")
    DirectorDTO DirectorToDirectorDto(Director director);

    @Named("mapMoviesToMovieDTOs")
    default List<MovieDTO> mapMoviesToMovieDTOs(List<Movie> movies) {
        return movies.stream()
                .map(movie -> new MovieDTO(movie.getId(), movie.getTitle())) // Create MovieDTO with id and name
                .toList();
    }
    static DirectorDTO DirectorToDirectorDtoStatic(Director director) {
        return INSTANCE.DirectorToDirectorDto(director);
    }
}
