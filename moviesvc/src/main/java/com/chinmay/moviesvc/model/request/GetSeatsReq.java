package com.chinmay.moviesvc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSeatsReq {


    @JsonProperty("timing")
    String timing;

    @JsonProperty("movieId")
    int movieId;

    @JsonProperty("theatreId")
    String theatreId;



    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }
}
