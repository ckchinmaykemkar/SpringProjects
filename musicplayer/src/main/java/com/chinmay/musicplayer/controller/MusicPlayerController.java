package com.chinmay.musicplayer.controller;


import com.chinmay.musicplayer.models.request.*;
import com.chinmay.musicplayer.models.response.BaseResponse;
import com.chinmay.musicplayer.port.MusicPlayerPort;
import com.chinmay.musicplayer.shared.entity.Songs;
import com.chinmay.musicplayer.shared.entity.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicPlayerController {


    @Autowired
    MusicPlayerPort port;



    @GetMapping(value = "/getAllUsers")
    public List<Users> getAllUser()  {
        //BaseResponse resp = new BaseResponse();
        return port.getAllUsers();
    }

    @GetMapping(value = "/getAllSongs")
    public List<Songs> getAllSongs()  {
        //BaseResponse resp = new BaseResponse();
        return port.getAllSongs();
    }


    @PostMapping(value = "/addUser")
    public BaseResponse addUser(@RequestBody UserReq req)  {
        BaseResponse resp = new BaseResponse();
        try {
            resp= port.addUser(req);
        }catch (JsonProcessingException jx){
            jx.printStackTrace();
        }
        return resp;
    }

    @PostMapping(value = "/addSongs")
    public BaseResponse addSongs(@RequestBody List<SongsReq> songsListReq)  {
        BaseResponse resp = new BaseResponse();
        resp = port.addSongs(songsListReq);
        return resp;
    }

    @PostMapping(value = "/addArtist")
    public BaseResponse addArtist(@RequestBody ArtistReq artist)  {
        BaseResponse resp = new BaseResponse();
        resp = port.addArtist(artist);
        return resp;
    }

    @PostMapping(value = "/createPlayList")
    public BaseResponse createPlayList(@RequestBody UserPlaylistReq req)  {
        BaseResponse resp = new BaseResponse();
        resp = port.createPlayList(req);
        return resp;
    }

    @PostMapping(value = "/addAlbum")
    public BaseResponse addAlbum(@RequestBody AlbumsReq req)  {
        BaseResponse resp = new BaseResponse();
        resp = port.addAlbum(req);
        return resp;
    }



}
