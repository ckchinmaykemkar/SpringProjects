package com.chinmay.musicplayer.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPlaylistReq {
    @JsonProperty("user")
    UserReq user;

    @JsonProperty("playlist")
    Playlist playlist;

    public UserReq getUser() {
        return user;
    }

    public void setUser(UserReq user) {
        this.user = user;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
