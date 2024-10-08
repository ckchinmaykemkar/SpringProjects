package com.chinmay.moviesvc.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookSeats {


    @JsonProperty("rowSeq")
    String rowSeq;

    @JsonProperty("seatNum")
    int seatNum;

    @JsonProperty("type")
    String type;


    public String getRowSeq() {
        return rowSeq;
    }

    public void setRowSeq(String rowSeq) {
        this.rowSeq = rowSeq;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
