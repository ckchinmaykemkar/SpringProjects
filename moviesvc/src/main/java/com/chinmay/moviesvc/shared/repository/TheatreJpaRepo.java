package com.chinmay.moviesvc.shared.repository;

import com.chinmay.moviesvc.shared.entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TheatreJpaRepo extends JpaRepository<TheatreEntity,Long> {


    @Query(name="SELECT t FROM TheatreEntity t where t.movieId = ?1")
    public List<TheatreEntity> getByMovieId(int movieId);
}
