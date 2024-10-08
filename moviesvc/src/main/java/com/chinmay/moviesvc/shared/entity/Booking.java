package com.chinmay.moviesvc.shared.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name="bookingId")
    String bookingId;

    @Column(name="theatreId")
    String theatreId;

    @Column(name="movieId")
    int movieId;

    @Column(name="userId")
    String userId;


    @Column(name="rowSeq")
    String rowSeq;

    @Column(name="seatNum")
    int seatNum;

    @Column(name="type")
    String type;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
