package com.chinmay.moviesvc.port;

import com.chinmay.moviesvc.model.request.GetSeatsReq;
import com.chinmay.moviesvc.model.request.*;
import com.chinmay.moviesvc.model.request.GetShowsRequest;
import com.chinmay.moviesvc.model.response.BaseResponse;
import com.chinmay.moviesvc.model.response.GetSeatsFinalResponse;
import com.chinmay.moviesvc.model.response.GetShowsFinalResponse;
import com.chinmay.moviesvc.shared.entity.MovieEntity;
import com.chinmay.moviesvc.shared.entity.SeatEntity;
import com.chinmay.moviesvc.shared.entity.TheatreEntity;

import java.util.List;

public interface MoviePort {

   BaseResponse addMovies(List<MovieEntity> request) ;

   BaseResponse addTheatre(List<TheatreEntity> request) ;

   BaseResponse addSeat(List<SeatEntity> request);

   GetShowsFinalResponse getShows(GetShowsRequest request);

   GetSeatsFinalResponse getSeatsByTiming(GetSeatsReq request);

   BaseResponse bookSeats(BookSeatsReq req);

}
