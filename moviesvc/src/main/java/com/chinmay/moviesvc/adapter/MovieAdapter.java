package com.chinmay.moviesvc.adapter;

import com.chinmay.moviesvc.exception.MovieException;
import com.chinmay.moviesvc.model.request.GetSeatsReq;
import com.chinmay.moviesvc.model.request.*;
import com.chinmay.moviesvc.model.request.GetShowsRequest;
import com.chinmay.moviesvc.model.response.*;
import com.chinmay.moviesvc.port.MoviePort;
import com.chinmay.moviesvc.shared.entity.Booking;
import com.chinmay.moviesvc.shared.entity.MovieEntity;
import com.chinmay.moviesvc.shared.entity.SeatEntity;
import com.chinmay.moviesvc.shared.entity.TheatreEntity;
import com.chinmay.moviesvc.shared.repository.BookingShowJpaRepo;
import com.chinmay.moviesvc.shared.repository.MovieJpaRepo;
import com.chinmay.moviesvc.shared.repository.SeatJpaRepo;
import com.chinmay.moviesvc.shared.repository.TheatreJpaRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class MovieAdapter implements MoviePort {
    private static final Logger logger = LogManager.getLogger(MovieAdapter.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MovieJpaRepo movieRepo;

    @Autowired
    TheatreJpaRepo theatreRepo;

    @Autowired
    SeatJpaRepo seatRepo;

    @Autowired
    BookingShowJpaRepo bookingRepo;

    @Override
    public BaseResponse addMovies(List<MovieEntity> request) {
        BaseResponse response = new BaseResponse();
        try {
            movieRepo.saveAll(request);

            response.setStatusMsg("Success");
            response.setStatusCode("200");
            response.setStatusDesc("Success");



        }catch (MovieException ex){
            response.setStatusMsg("Error Occurred");
            response.setStatusCode("500");
            response.setStatusDesc("Something went wrong");

        } finally {
            try {
                logger.info(objectMapper.writeValueAsString(request.toString()) + ", " + objectMapper.writeValueAsString(response.toString()));
            }catch (JsonProcessingException ex){
                ex.printStackTrace();
            }
        }
        return response;
    }

    @Override
    public BaseResponse addTheatre(List<TheatreEntity> request) {
        BaseResponse response = new BaseResponse();
      try {
            theatreRepo.saveAll(request);
            response.setStatusMsg("Success");
            response.setStatusCode("200");
            response.setStatusDesc("Success");
         }catch (MovieException ex){
            logger.error(ex.getMessage());
            response.setStatusMsg("Error Occurred");
            response.setStatusCode("500");
            response.setStatusDesc("Something went wrong");

        } finally {
            try {
                logger.info(objectMapper.writeValueAsString(request.toString()) + ", " + objectMapper.writeValueAsString(response.toString()));
            }catch (JsonProcessingException ex){
                ex.printStackTrace();
            }
        }
        return response;
    }

    @Override
    public BaseResponse addSeat(List<SeatEntity> request) {
        BaseResponse response = new BaseResponse();
        try {
            seatRepo.saveAll(request);

            response.setStatusMsg("Success");
            response.setStatusCode("200");
            response.setStatusDesc("Success");



        }catch (MovieException ex){
            logger.error(ex.getMessage());
            response.setStatusMsg("Error Occurred");
            response.setStatusCode("500");
            response.setStatusDesc("Something went wrong");

        } finally {
            try {
                logger.info(objectMapper.writeValueAsString(request.toString()) + ", " + objectMapper.writeValueAsString(response.toString()));
            }catch (JsonProcessingException ex){
                ex.printStackTrace();
            }
        }
        return response;
    }

    @Override
    public GetShowsFinalResponse getShows(GetShowsRequest request) {
        GetShowsFinalResponse response = new GetShowsFinalResponse();
        try {
            List<MovieEntity> moviesList =  movieRepo.getByMovieName(request.getMovieName());
            if(moviesList.isEmpty()){
                response.setStatusMsg("Movie not available");
                response.setStatusCode("200");
                response.setStatusDesc("Movie not available");
            }

            int movieId = moviesList.get(0).getId();
            List<TheatreEntity> theatresList = theatreRepo.getByMovieId(movieId);

            List<GetShowsResponse> shows = new ArrayList<>();
            LinkedHashMap<String,List<TheatreEntity>> theatreMap= theatresList.stream().collect(Collectors.groupingBy(TheatreEntity::getTheatreId,
                    LinkedHashMap::new,Collectors.toList()));

            for(Map.Entry<String,List<TheatreEntity>> entry:theatreMap.entrySet()){
                List<String> timings = entry.getValue().stream().map(TheatreEntity::getTiming).toList();
                GetShowsResponse resp = new GetShowsResponse();
                resp.setTheatreId(entry.getKey());
                resp.setMovieId(entry.getValue().get(0).getMovieId());
                resp.setTheatreName(entry.getValue().get(0).getName());
                resp.setMovieName(request.getMovieName());
                resp.setTimings(timings);
                shows.add(resp);
            }

            response.setListOfShows(shows);
            response.setStatusMsg("Success");
            response.setStatusCode("200");
            response.setStatusDesc("Success");
        }catch (MovieException ex){
            logger.error(ex.getMessage());
            response.setStatusMsg("Error Occurred");
            response.setStatusCode("500");
            response.setStatusDesc("Something went wrong");
        }

        return response;
    }

    @Override
    public GetSeatsFinalResponse getSeatsByTiming(GetSeatsReq request) {
        GetSeatsFinalResponse response = new GetSeatsFinalResponse();

        try {
            List<SeatEntity> seatsList = seatRepo.getSeatsByMovieIdAndTheatreIdAndTiming(request.getMovieId(), request.getTheatreId(), request.getTiming());
            List<SeatsInfo> seatsinfo = seatsList.stream().map(it->
            {
                SeatsInfo si = new SeatsInfo();
                si.setSeatNum(it.getSeatNum());
                si.setRowSeq(it.getRowSeq());
                si.setStatus(it.getStatus());
                si.setType(it.getType());
                return si;
            }).collect(Collectors.toList());

            response.setSeatsInfos(seatsinfo);
            response.setStatusMsg("Success");
            response.setStatusCode("200");
            response.setStatusDesc("Success");
        }catch (MovieException ex){
            logger.error(ex.getMessage());
            response.setStatusMsg("Error Occurred");
            response.setStatusCode("500");
            response.setStatusDesc("Something went wrong");

        }
        return null;
    }

    @Override
    public BaseResponse bookSeats(BookSeatsReq request) {
        BaseResponse response = new BaseResponse();

        try{
            String bookingId = generatePlaylistId("BMS");

            List<Booking> bookings = request.getSeats().stream().map(it->
            {
                Booking book = new Booking();
                book.setBookingId(bookingId);
                book.setMovieId(request.getMovieId());
                book.setTheatreId(request.getTheatreId());
                book.setType(it.getType());
                book.setSeatNum(it.getSeatNum());
                book.setRowSeq(it.getRowSeq());
                book.setUserId(request.getUserId());
                return book;
            }).collect(Collectors.toList());

            bookingRepo.saveAll(bookings);
            //modify the sstatus of these seats in Seats Master table






        }catch (MovieException ex){
            logger.error(ex.getMessage());
            response.setStatusMsg("Error Occurred");
            response.setStatusCode("500");
            response.setStatusDesc("Something went wrong");
        }

        return null;
    }

    private String generatePlaylistId(String prefix) {
        return prefix + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}

