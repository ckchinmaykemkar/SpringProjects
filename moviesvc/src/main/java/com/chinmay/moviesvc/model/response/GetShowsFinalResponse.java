package com.chinmay.moviesvc.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetShowsFinalResponse extends BaseResponse {

    public List<GetShowsResponse> getListOfShows() {
        return listOfShows;
    }

    public void setListOfShows(List<GetShowsResponse> listOfShows) {
        this.listOfShows = listOfShows;
    }

    @JsonProperty("getShowsResponse")
    public List<GetShowsResponse> listOfShows = new ArrayList<GetShowsResponse>();
}
