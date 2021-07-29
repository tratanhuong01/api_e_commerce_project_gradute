package com.api.api_e_commerce_project_gradute.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

  @Autowired
  NewsRepository newsRepository;

  public List<News> getAllNews() {
    return newsRepository.findAll();
  }

  public News getNewsById(String idNews) {
    return newsRepository.getById(idNews);
  }

  public News addNews(News news) {
    return newsRepository.save(news);
  }

}
