package com.news.newsfeed.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="News_Feed")
@Data
public class News_Feed {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    Long id;

    @Column(name ="author")
    String author;

    @Column(name ="title")
    String title;

    @Column(name ="url",length = 10000)
    String url;


}
