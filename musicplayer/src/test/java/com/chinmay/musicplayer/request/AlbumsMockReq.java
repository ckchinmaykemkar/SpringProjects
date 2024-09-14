package com.chinmay.musicplayer.request;

import com.chinmay.musicplayer.models.request.AlbumsReq;
import com.fasterxml.jackson.databind.ObjectMapper;

public  class AlbumsMockReq {


    public static AlbumsReq getAlbumsReq(){
        String jsonRequest = "{\n" +
                "  \"albumName\": \"Greatest Hits\",\n" +
                "  \"artistName\": \"John Doe\",\n" +
                "  \"artistId\": 1,\n" +
                "  \"songs\": [\n" +
                "    {\n" +
                "      \"songId\": 1,\n" +
                "      \"songName\": \"First Song\",\n" +
                "      \"language\": \"English\",\n" +
                "      \"duration\": 210,\n" +
                "      \"artistId\": 123\n" +
                "    },\n" +
                "    {\n" +
                "      \"songId\": 2,\n" +
                "      \"songName\": \"Second Song\",\n" +
                "      \"language\": \"Spanish\",\n" +
                "      \"duration\": 180,\n" +
                "      \"artistId\": 123\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        AlbumsReq albumRequest = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert JSON string to AlbumRequest object
             albumRequest = objectMapper.readValue(jsonRequest, AlbumsReq.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return albumRequest;
    }
}
