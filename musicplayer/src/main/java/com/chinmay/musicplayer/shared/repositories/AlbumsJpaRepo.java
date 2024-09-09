package com.chinmay.musicplayer.shared.repositories;

import com.chinmay.musicplayer.shared.entity.Album;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumsJpaRepo extends JpaRepository<Album,Long> {

    @Query(value="SELECT a FROM Album a WHERE a.id =?1")
    public Album getAlbumById(int id);
}
