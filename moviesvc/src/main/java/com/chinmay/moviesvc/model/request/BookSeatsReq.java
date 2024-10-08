package com.chinmay.moviesvc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class BookSeatsReq {

    @JsonProperty("theatreId")
    String theatreId;

    @JsonProperty("movieId")
    int movieId;

    @JsonProperty("timing")
    String timing;

    @JsonProperty("userId")
    String userId;

    @JsonProperty("seats")
    public List<BookSeats> seats = new ArrayList<>();

    public List<BookSeats> getSeats() {
        return seats;
    }

    public void setSeats(List <BookSeats> seats) {
        this.seats = seats;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
