package com.chinmay.moviesvc.controller;


import com.chinmay.moviesvc.model.request.GetShowsRequest;
import com.chinmay.moviesvc.model.response.BaseResponse;
import com.chinmay.moviesvc.port.MoviePort;
import com.chinmay.moviesvc.shared.entity.MovieEntity;
import com.chinmay.moviesvc.shared.entity.SeatEntity;
import com.chinmay.moviesvc.shared.entity.TheatreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MoviePort port;

    @PostMapping("/addMovie")
    public BaseResponse saveMovie(@RequestBody List<MovieEntity> req) {
        return port.addMovies(req);
    }

    @PostMapping("/addTheatre")
    public BaseResponse addTheatre(@RequestBody List<TheatreEntity> req) {
        return port.addTheatre(req);
    }

    @PostMapping("/addSeats")
    public BaseResponse addSeats(@RequestBody List<SeatEntity> req) {
        return port.addSeat(req);
    }

    @GetMapping("/getShows")
    public BaseResponse addSeats(@RequestBody GetShowsRequest req) {
        return port.getShows(req);
    }


}
