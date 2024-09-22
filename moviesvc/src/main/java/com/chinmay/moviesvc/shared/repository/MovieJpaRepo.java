package com.chinmay.moviesvc.shared.repository;

import com.chinmay.moviesvc.shared.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@Transactional
public interface MovieJpaRepo extends JpaRepository<MovieEntity,Long> {


    @Query(value = "SELECT m FROM MovieEntity m where m.name LIKE %?1%")
    List<MovieEntity> getByMovieName(String name);

}
