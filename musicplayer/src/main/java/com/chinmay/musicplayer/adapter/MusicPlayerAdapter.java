package com.chinmay.musicplayer.adapter;

import com.chinmay.musicplayer.models.request.*;
import com.chinmay.musicplayer.models.response.BaseResponse;
import com.chinmay.musicplayer.port.MusicPlayerPort;
import com.chinmay.musicplayer.shared.entity.Album;
import com.chinmay.musicplayer.shared.entity.Artist;
import com.chinmay.musicplayer.shared.entity.Playlist;
import com.chinmay.musicplayer.shared.entity.Songs;
import com.chinmay.musicplayer.shared.entity.Users;
import com.chinmay.musicplayer.shared.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;
import java.util.UUID;

@Service
class MusicPlayerAdapter implements MusicPlayerPort {
    private static final Logger logger = LogManager.getLogger(MusicPlayerAdapter.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();




    @Autowired
    AlbumsJpaRepo albumRepo;

    @Autowired
    ArtistJpaRepo artistRepo;

    @Autowired
    PlaylistJpaRepo playlistRepo;

    @Autowired
    SongsJpaRepo songsRepo;

    @Autowired
    UsersJpaRepo userRepo;


    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<Songs> getAllSongs() {
        return songsRepo.findAll();
    }

    @Override
    public BaseResponse addUser(UserReq req) throws JsonProcessingException {
        BaseResponse response = new BaseResponse();
        try {

            Users user = new Users();
            user.setUserName(req.getUserName());
            userRepo.save(user);
            response.setStatus("Success");
            response.setStatusCode(200);
            response.setStatusDesc("Success");


        } catch (Exception ex){
            ex.printStackTrace();
            response.setStatus("Error Occurred");
            response.setStatusCode(500);
            response.setStatusDesc("Something went wrong");

        } finally {
            logger.info(objectMapper.writeValueAsString(req.toString())+", "+ objectMapper.writeValueAsString(response.toString()));

        }
        return response;
    }

    @Override
    public BaseResponse addSongs(List<SongsReq> songsList) {
        BaseResponse response = new BaseResponse();

        try {
             songsList.stream().forEach(i->
             {
                 Songs song = new Songs();
                 song.setSongName(i.getSongName());
                 song.setDuration(i.getDuration());
                 song.setArtistId(i.getArtistId());
             });
            response.setStatus("Success");
            response.setStatusCode(200);
            response.setStatusDesc("Success");


        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus("Error Occurred");
            response.setStatusCode(500);
            response.setStatusDesc("Something went wrong");
        }

        return response;
    }

    @Override
    public BaseResponse addArtist(ArtistReq req) {
        BaseResponse response = new BaseResponse();
        try {
            Artist currArtist =artistRepo.getArtistByName(req.getName());
            Artist ar = currArtist!=null ? currArtist : new Artist();

            ar.setArtistName(req.getName());

            ar = artistRepo.save(ar);
            int artistId = ar.getId();

            req.getAlbums().stream().forEach(i->

                    {
                        Album album = new Album();
                        album.setAlbumName(i.getAlbumName());
                        album.setArtistId(artistId);
                        album.setArtistName(req.getName());
                        Album aid = albumRepo.save(album);

                        i.getSongs().stream().forEach(it->
                                {
                                    Songs song = new Songs();
                                    song.setArtistId(artistId);
                                    song.setSongName(it.getSongName());
                                    song.setAlbumId(aid.getId());
                                    song.setDuration(it.getDuration());
                                    songsRepo.save(song);
                                }


                                );
                    }

                    );
            response.setStatus("Success");
            response.setStatusCode(200);
            response.setStatusDesc("Success");
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(ex);
            response.setStatus("Error Occurred");
            response.setStatusCode(500);
            response.setStatusDesc("Something went wrong");
        }
        return response;
    }

    @Override
    public BaseResponse createPlayList(UserPlaylistReq req) {

        BaseResponse response = new BaseResponse();

        try {
            String playListId = generatePlaylistId();
            String playListName = req.getPlaylist().getPlaylistName();
            req.getPlaylist().getSongs().stream().forEach(it->

                    {
                        Playlist pl = new Playlist();
                        pl.setUserId(req.getUser().getUserId());
                        pl.setPlaylistId(playListId);
                        pl.setPlaylistName(playListName);
                        pl.setSongId(it.getSongId());

                        playlistRepo.save(pl);
                    }

                    );
            response.setStatus("Success");
            response.setStatusCode(200);
            response.setStatusDesc("Success");
        }catch (Exception ex){
            ex.printStackTrace();

            logger.error(ex);
            response.setStatus("Error Occurred");
            response.setStatusCode(500);
            response.setStatusDesc("Something went wrong");
        }


        return null;
    }

    @Override
    public BaseResponse addAlbum(AlbumsReq req) {
        BaseResponse response = new BaseResponse();

        try{
            Artist artist = artistRepo.getArtistByName(req.getArtistName()) != null ? artistRepo.getArtistByName(req.getArtistName()) : new Artist();
            artist.setArtistName(req.getArtistName());
            artist = artistRepo.save(artist);
            int artistId = artist.getId();

            Album album = new Album();
            album.setAlbumName(req.getAlbumName());
            album.setArtistName(req.getArtistName());
            album.setArtistId(artistId);
            Album savedAlbum = albumRepo.save(album);
            req.getSongs().stream().forEach(it->

                    {
                        Songs song = new Songs();
                        song.setAlbumId(savedAlbum.getId());
                        song.setArtistId(artistId);
                        song.setSongName(it.getSongName());
                        song.setDuration(it.getDuration());
                        songsRepo.save(song);
                    }

                    );

            response.setStatus("Success");
            response.setStatusCode(200);
            response.setStatusDesc("Success");



        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus("Error Occurred");
            response.setStatusCode(500);
            response.setStatusDesc("Something went wrong");
        }

        return response;
    }

    private String generatePlaylistId() {
        return "PL" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
