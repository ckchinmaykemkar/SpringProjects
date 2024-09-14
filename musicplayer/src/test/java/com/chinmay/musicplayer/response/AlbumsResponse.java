package com.chinmay.musicplayer.response;

import com.chinmay.musicplayer.models.request.AlbumsReq;
import com.chinmay.musicplayer.models.response.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AlbumsResponse {


    public static BaseResponse getSuccessResponse(){

        String jsonReq = "{\n" +
                "  \"status\": \"Success\",\n" +
                "  \"statusDesc\": \"Success\",\n" +
                "  \"statusCode\": 200\n" +
                "}\n";

        BaseResponse response=null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert JSON string to AlbumRequest object
            response = objectMapper.readValue(jsonReq, BaseResponse.class);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return response;
    }
}
