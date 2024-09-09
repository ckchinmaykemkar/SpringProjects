package com.chinmay.musicplayer.shared.repositories;

import com.chinmay.musicplayer.shared.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsJpaRepo extends JpaRepository<Songs,Long> {
}
