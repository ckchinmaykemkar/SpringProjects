package com.chinmay.moviesvc.shared.repository;

import com.chinmay.moviesvc.shared.entity.SeatEntity;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SeatJpaRepo extends JpaRepository<SeatEntity,Long> {
    @Query(name="SELECT s FROM SeatEntity s WHERE s.theatreId =?1 and s.movieId =?2")
    List<SeatEntity> getSeatsByMovieIdAndTheatreId(int movieId, String theatreId);
}
