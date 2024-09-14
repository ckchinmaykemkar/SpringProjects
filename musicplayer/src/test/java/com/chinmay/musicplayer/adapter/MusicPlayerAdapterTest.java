package com.chinmay.musicplayer.adapter;


import com.chinmay.musicplayer.models.request.AlbumsReq;
import com.chinmay.musicplayer.models.response.BaseResponse;
import com.chinmay.musicplayer.request.AlbumsMockReq;
import com.chinmay.musicplayer.response.AlbumsResponse;
import com.chinmay.musicplayer.shared.entity.Album;
import com.chinmay.musicplayer.shared.entity.Artist;
import com.chinmay.musicplayer.shared.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MusicPlayerAdapterTest {

    @Mock
    AlbumsJpaRepo albumRepo;

    @Mock
    ArtistJpaRepo artistRepo;

    @Mock
    PlaylistJpaRepo playlistRepo;

    @Mock
    SongsJpaRepo songsRepo;

    @Mock
    UsersJpaRepo userRepo;

    @InjectMocks
    private MusicPlayerAdapter musicPlayer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testAddAlbum_Success(){
        AlbumsReq request = AlbumsMockReq.getAlbumsReq();
        BaseResponse expectedResponse = AlbumsResponse.getSuccessResponse();

        Artist newArtist = new Artist();
        newArtist.setId(1);
        newArtist.setArtistName("John Doe");
        newArtist.setAge(0);

        Album album = new Album();
        album.setId(1);
        album.setAlbumName(request.getAlbumName());
        album.setArtistName(request.getArtistName());
        album.setArtistId(request.getArtistId());

        when(artistRepo.getArtistByName(request.getArtistName())).thenReturn(newArtist);
        when(artistRepo.save(newArtist)).thenReturn(newArtist);
        when(albumRepo.save(any(Album.class))).thenReturn(album);

        BaseResponse response = musicPlayer.addAlbum(request);
        assertEquals(expectedResponse.getStatus(), response.getStatus());



    }



}
