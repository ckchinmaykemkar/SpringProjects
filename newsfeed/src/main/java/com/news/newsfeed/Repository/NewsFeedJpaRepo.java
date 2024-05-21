package com.news.newsfeed.Repository;

import com.news.newsfeed.entity.News_Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Repository
@Transactional
public interface NewsFeedJpaRepo extends JpaRepository<News_Feed, Long> {


    @Query(value="SELECT a FROM News_Feed a")
    List<News_Feed> getStreamOfRecs();

}
