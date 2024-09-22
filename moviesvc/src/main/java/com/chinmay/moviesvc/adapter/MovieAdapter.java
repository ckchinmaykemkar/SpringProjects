package com.chinmay.moviesvc.adapter;

import com.chinmay.moviesvc.exception.MovieException;
import com.chinmay.moviesvc.model.request.GetShowsRequest;
import com.chinmay.moviesvc.model.response.BaseResponse;
import com.chinmay.moviesvc.model.response.GetShowsFinalResponse;
import com.chinmay.moviesvc.model.response.GetShowsResponse;
import com.chinmay.moviesvc.port.MoviePort;
import com.chinmay.moviesvc.shared.entity.MovieEntity;
import com.chinmay.moviesvc.shared.entity.SeatEntity;
import com.chinmay.moviesvc.shared.entity.TheatreEntity;
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

    private String generatePlaylistId() {
        return "TH" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}

