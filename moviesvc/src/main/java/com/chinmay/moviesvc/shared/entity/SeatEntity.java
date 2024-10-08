package com.chinmay.moviesvc.shared.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="seat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "theatreId")
    String theatreId;

    @Column(name = "movieId")
    int movieId;

    @Column(name="timing")
    String timing;

    @Column(name="rowSeq")
    String rowSeq;

    @Column(name="seatNum")
    int seatNum;

    @Column(name="status")
    String status;

    @Column(name="type")
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
