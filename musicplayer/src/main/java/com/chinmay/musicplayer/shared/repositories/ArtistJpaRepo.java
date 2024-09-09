package com.chinmay.musicplayer.shared.repositories;

import com.chinmay.musicplayer.shared.entity.Album;
import com.chinmay.musicplayer.shared.entity.Artist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistJpaRepo extends JpaRepository<Artist,Long> {

    @Query(value="SELECT a FROM Artist a WHERE a.artistName = ?1")
    public Artist getArtistByName(String name);
}
