package com.movie.movieApp.controller;
import com.movie.movieApp.dto.MovieReqDTO;
import com.movie.movieApp.model.Genre;
import com.movie.movieApp.model.Movie;
import com.movie.movieApp.model.Review;
import com.movie.movieApp.services.MovieService;
import com.movie.movieApp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/")
public class MovieController {
    private final MovieService movieService;
    private final ReviewService reviewService;

    @Autowired
    public MovieController(MovieService movieService, ReviewService reviewService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
    }
    @GetMapping("/movies") // get movies

    public List<Movie> GetMovies(){
        return movieService.getAllMoviesWithGenres();
    }

    @GetMapping("/")
    public String Home(){
        return "Connected to back-end successfully..";
    }

    @PostMapping("/movies")
    public ResponseEntity<String> createMovie(@RequestBody MovieReqDTO request) {
        Long directorId = request.getDirectorId();
        Long studioId = request.getStudioId();
        System.out.println(studioId + directorId);
        Movie movie = new Movie();
        movie.setId(request.getId());
        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
        movie.setGrossIncome(request.getGrossIncome());

        movieService.saveMovies(movie, directorId, studioId);

        return ResponseEntity.ok("Movie saved successfully");
    }


    @PutMapping(path = "/movies/{movieId}")     // update title and director
    public void UpdateMovie(@PathVariable("movieId") Long moveId,
    @RequestParam(required = false) String title,
    @RequestParam(required = false) String director
    ){
        movieService.UpdateMovie(moveId,title,director);


    }
    @DeleteMapping(path = "/movies/{id}") // delete movie
    public void DeleteMovie(@PathVariable("id") Long id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/movies/{movieId}/actors/{actorId}") // add actors to movie
    public void addActorsInMovie(
            @PathVariable Long movieId,
            @PathVariable Long actorId
    ) { movieService.AddActorsToMovies(movieId,actorId);
    }
    @PutMapping("/movies/{movieId}/income/{amount}")  // change income of movie
    public void ChangeIncome(
            @PathVariable Long movieId,
            @PathVariable int amount
    ){
        movieService.ChangeGrossIncome(movieId, amount);
    }
    @GetMapping("/findLargeGross/{amount}")  // find income higher than amount
    public Optional<Movie> findLargeGross(@PathVariable int amount){
        return movieService.findLargeGross(amount);
    }
    @PutMapping("/movies/{movieId}/{genreName}") // add genres
    public void changeGenre(@PathVariable Long movieId, @PathVariable List<Genre> genreName){ // change genre
        movieService.changeGenre(movieId, genreName);
    }
    @PutMapping("/movies/{movieId}/review") // add review
    public void AddReviews(@RequestBody Review review,
                           @PathVariable Long movieId){
        reviewService.saveReviews(review,movieId);
    }


}

