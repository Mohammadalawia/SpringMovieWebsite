package com.movie.movieApp.repository;


import com.movie.movieApp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    @Query("SELECT n FROM Review n WHERE n.comment = ?1")
    Optional<Review> findReviewByComment(String comment);


}
