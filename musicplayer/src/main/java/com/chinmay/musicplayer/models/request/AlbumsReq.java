package com.chinmay.musicplayer.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AlbumsReq {

    @JsonProperty("albumName")
    String albumName;

    @JsonProperty("artistName")
    String artistName;



    @JsonProperty("artistId")
    int artistId;


    @JsonProperty("songs")
    List<SongsReq> songs;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<SongsReq> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsReq> songs) {
        this.songs = songs;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
