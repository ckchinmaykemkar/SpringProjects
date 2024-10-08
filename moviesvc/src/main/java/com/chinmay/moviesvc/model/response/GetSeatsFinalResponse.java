package com.chinmay.moviesvc.model.response;

import com.chinmay.moviesvc.shared.entity.SeatEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GetSeatsFinalResponse extends BaseResponse {
//    @JsonProperty("seatsList")
//    public List<SeatEntity> seatsList = new ArrayList<>();

    @JsonProperty("seatsList")
    public List<SeatsInfo> seatsInfos = new ArrayList<>();

    public List<SeatsInfo> getSeatsInfos() {
        return seatsInfos;
    }

    public void setSeatsInfos(List<SeatsInfo> seatsInfos) {
        this.seatsInfos = seatsInfos;
    }



}
