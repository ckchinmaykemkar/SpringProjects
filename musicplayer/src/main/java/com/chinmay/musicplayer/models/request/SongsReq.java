package com.chinmay.musicplayer.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SongsReq {
    @JsonProperty("songId")
    int songId;

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @JsonProperty("songName")
    String songName;

    @JsonProperty("language")
    String language;

    @JsonProperty("duration")
    int duration;

    @JsonProperty("artistId")
    int artistId;

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
