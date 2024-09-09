package com.chinmay.moviesvc.shared.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MovieMongoRepository extends MongoRepository<Movie, String> {

    // Custom finder method by title
    List<Movie> findByTitle(String title);

    // Custom finder method by director
    List<Movie> findByDirector(String director);

    // Custom query using @Query annotation


    @Query("{ 'title': ?0, 'director': ?1 }")
    List<Movie> findByTitleAndDirector(String title, String director);

    @Query("{ 'releaseDate': { $gte: ?0, $lte: ?1 } }")
    List<Movie> findMoviesBetweenDates(LocalDate startDate, LocalDate endDate);

    @Query("{ 'rating': { $gt: ?0 } }")
    List<Movie> findMoviesWithRatingGreaterThan(double rating);


}
