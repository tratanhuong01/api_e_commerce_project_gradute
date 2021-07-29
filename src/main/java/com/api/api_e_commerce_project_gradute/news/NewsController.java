package com.api.api_e_commerce_project_gradute.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

  @Autowired
  NewsService newsService;

  @CrossOrigin
  @GetMapping("news")
  public List<News> getAllNews() {
    return newsService.getAllNews();
  }

  @CrossOrigin
  @GetMapping("news/{idNews}")
  public News getNewsById(@PathVariable String idNews) {
    return newsService.getNewsById(idNews);
  }

  @CrossOrigin
  @PostMapping("news")
  public News addNews(@RequestBody News news) {
    return newsService.addNews(news);
  }

  @CrossOrigin
  @PutMapping("news")
  public News updateNews(@RequestBody News news) {
    return newsService.addNews(news);
  }

}
