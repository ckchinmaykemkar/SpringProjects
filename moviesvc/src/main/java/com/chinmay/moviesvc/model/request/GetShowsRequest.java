package com.chinmay.moviesvc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
public class GetShowsRequest {
    @JsonProperty("userId")
    String userId;

    @JsonProperty("movieName")
    String movieName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
