package com.chinmay.musicplayer.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistReq {

    @JsonProperty("name")
    String name;

    @JsonProperty("albums")
    List<AlbumsReq> albums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlbumsReq> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumsReq> albums) {
        this.albums = albums;
    }
}
