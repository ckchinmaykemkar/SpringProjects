package com.news.newsfeed.service;

import com.news.newsfeed.Repository.NewsFeedJpaRepo;
import com.news.newsfeed.entity.News_Feed;
import com.news.newsfeed.model.response.Article;
import com.news.newsfeed.model.response.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NewsAdapter {


    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;

    @Autowired
    NewsFeedJpaRepo repo;

    private static final String API_KEY = "1f2b302d9cd24028b364c0892c59996f";
    private static final String URL = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=" + API_KEY;


    @Transactional(readOnly = false)
    public ResponseEntity<NewsResponse> getTopNews(){

        List<News_Feed> st = repo.getStreamOfRecs();

        ResponseEntity<NewsResponse> topheadlines = restTemplate.getForEntity(URL,NewsResponse.class);
        List<Article> topNews = topheadlines.getBody().getArticles().stream().collect(Collectors.toList());
        topNews.forEach(it->{

            if(st.stream().filter(s-> s.getAuthor().equals(it.getAuthor()) && s.getUrl().equals(it.getUrl())).count() == 0 ) {
                News_Feed nf = new News_Feed();
                nf.setAuthor(it.getAuthor());
                nf.setTitle(it.getTitle());
                nf.setUrl(it.getUrl());

                repo.save(nf);
            }
                }



                );
        return  topheadlines;
    }

    public List<News_Feed> getArticles(){
        List<News_Feed> result = repo.findAll();
        return result;
    }
}
