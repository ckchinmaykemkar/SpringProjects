package com.news.newsfeed.controller;

import com.news.newsfeed.entity.News_Feed;
import com.news.newsfeed.model.response.NewsResponse;
import com.news.newsfeed.service.NewsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsAdapter service;


    @GetMapping("/getTopCrunchNews")
    public ResponseEntity<NewsResponse> getNews(){
        return service.getTopNews();
    }

    @GetMapping("/getSavedArticles")
    public List<News_Feed> getSavedArticles(){
        return service.getArticles();
    }


}
