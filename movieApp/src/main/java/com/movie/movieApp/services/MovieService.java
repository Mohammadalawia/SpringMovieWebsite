package com.movie.movieApp.services;

import com.movie.movieApp.model.*;
import com.movie.movieApp.repository.ActorRepository;
import com.movie.movieApp.repository.DirectorRepository;
import com.movie.movieApp.repository.MovieRepository;
import com.movie.movieApp.repository.StudioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final StudioRepository studioRepository;
    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository, DirectorService directorService, DirectorRepository directorRepository, StudioRepository studioRepository) {

        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.studioRepository = studioRepository;

    }
    public void AddActorsToMovies(Long movieId, Long actorId){ // connect actors to movies
        {
            Optional<Movie> optionalMovie = movieRepository.findById(movieId); // optional check if movie exists before connecting
            if (optionalMovie.isPresent()) {
                Movie movie = optionalMovie.get();
                Optional<Actor> actor = actorRepository.findById(actorId);
                if (actor.isPresent()) {
                    movie.addActor(actor.get());
                    movieRepository.save(movie);
                } else {
                    throw new EntityNotFoundException("Actor with ID " + actorId + " not found.");
                }
            } else {
                throw new EntityNotFoundException("Movie with ID " + movieId + " not found.");
            }
        }
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();

    }
    public List<Movie> getAllMoviesWithGenres() {
        return movieRepository.findAllMoviesWithGenres();
    }
    public void ChangeGrossIncome(Long movieId,int amount){ // change movie gross icome
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()){
            Movie newMovie = movie.get();
            newMovie.setGrossIncome(amount);
            movieRepository.save(newMovie);

        }
        else
            throw new EntityNotFoundException("Movie with ID " + movieId + " not found.");
    }
    public void saveMovies(Movie movie, Long directorId, Long studioId) {
        Optional<Movie> movieOptional = movieRepository.findById(movie.getId());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("ID is already taken");
        }

        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new IllegalStateException("Director not found"));
        Studio studio = studioRepository.findById(studioId)
                .orElseThrow(() -> new IllegalStateException("Studio not found"));

        movie.setDirector(director);
        movie.setStudio(studio);

        try {
            movieRepository.save(movie);
        } catch (Exception e) {
            System.err.println("Error saving movie: " + e.getMessage());
            throw new IllegalStateException("An error occurred while saving the movie.", e);
        }
    }





    public void deleteMovie(Long id) { // delete movies
        boolean exists = movieRepository.existsById(id);
        System.out.println(exists);
        if (!exists) {
            throw new IllegalStateException("movie with the Id" + id + " doesn't exist");
        } else {
            movieRepository.deleteById(id);
        }

    }

    @Transactional
    public void UpdateMovie(Long movieId, String title, String director) { // update
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new IllegalStateException("movie with the Id"+ movieId + " doesn't exist"));
        if(title != null && !title.isEmpty() && !Objects.equals(movie.getTitle(), title)){
            movie.setTitle(title);
        }


    }

    public Optional<Movie> findLargeGross(int amount) { // find larger than specified amount
        return movieRepository.findLargeGross(amount);
    }

    public void changeGenre(Long movieId,List<Genre> genreName) { // change genre
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new IllegalStateException("movie with the Id"+ movieId + " doesn't exist"));
        movie.setGenre(genreName);
        movieRepository.save(movie);
    }
}