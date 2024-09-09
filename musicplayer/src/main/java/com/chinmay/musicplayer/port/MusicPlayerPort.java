package com.chinmay.musicplayer.port;

import com.chinmay.musicplayer.models.request.*;
import com.chinmay.musicplayer.models.response.BaseResponse;
import com.chinmay.musicplayer.shared.entity.Songs;
import com.chinmay.musicplayer.shared.entity.Users;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

 public interface MusicPlayerPort {

     List<Users> getAllUsers();

     List<Songs> getAllSongs();

     public BaseResponse addUser(UserReq req) throws JsonProcessingException;

     public BaseResponse addSongs(List<SongsReq> songsList);

     public BaseResponse addArtist(ArtistReq artist);

     public BaseResponse createPlayList(UserPlaylistReq req);

     public BaseResponse addAlbum(AlbumsReq req);
}
