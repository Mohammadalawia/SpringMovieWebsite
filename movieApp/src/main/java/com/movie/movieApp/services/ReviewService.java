package com.movie.movieApp.services;
import com.movie.movieApp.model.Movie;
import com.movie.movieApp.repository.MovieRepository;
import com.movie.movieApp.repository.ReviewRepository;
import com.movie.movieApp.model.Review;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;


    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public List<Review> getReviews(){
        System.out.println(reviewRepository.findAll());
        return reviewRepository.findAll();

    }
    public void saveReviews(Review review, Long movieId){
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isEmpty()){
            throw new IllegalStateException(" review id taken");
        }
        review.setMovie(movie.get());
        reviewRepository.save(review);


    }
}