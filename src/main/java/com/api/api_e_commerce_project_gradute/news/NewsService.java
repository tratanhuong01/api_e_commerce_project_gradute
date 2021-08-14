package com.api.api_e_commerce_project_gradute.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

  @Autowired
  NewsRepository newsRepository;

  public List<News> getAllNews() {
    return newsRepository.findAll();
  }

  public Optional<News> getNewsById(Long idNews) {
    return newsRepository.findById(idNews);
  }

  public News addNews(News news) {
    news.setTimeCreated(new Timestamp(new Date().getTime()));
    return newsRepository.save(news);
  }

  public News getNewsBySlug(String slug) {
    return newsRepository.getNewsBySlug(slug);
  }

}
