package com.chinmay.musicplayer.shared.repositories;

import com.chinmay.musicplayer.shared.entity.Playlist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistJpaRepo extends JpaRepository<Playlist,Long> {
}
