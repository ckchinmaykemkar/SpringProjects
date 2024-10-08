package com.chinmay.moviesvc.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public class SeatsInfo {


    @Column(name="rowSeq")
    String rowSeq;

    @Column(name="seatNum")
    int seatNum;

    @Column(name="status")
    String status;

    @Column(name="type")
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
