package com.chinmay.musicplayer.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    @JsonProperty("playlistName")
    String playlistName;

    @JsonProperty("songs")
    List<SongsReq> songs = new ArrayList<>();

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<SongsReq> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsReq> songs) {
        this.songs = songs;
    }
}
