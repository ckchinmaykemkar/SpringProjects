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

}
