package com.api.api_e_commerce_project_gradute.news;

import com.api.api_e_commerce_project_gradute.DTO.news.NewsDetailPage;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class  NewsController {

  @Autowired
  NewsService newsService;

  @GetMapping("news")
  public List<News> getNewsLimit() {
    return newsService.getNewsLimit(0,10);
  }

  @GetMapping("newsAll")
  public List<News> getAllNews() {
    return newsService.getAllNews();
  }

  @GetMapping("news/{offset}/{limit}")
  public List<News> getAllNewsLimit(@PathVariable int offset, @PathVariable int limit) {
    return newsService.getAllNews();
  }

  @GetMapping("news/{idNews}")
  public Optional<News> getNewsById(@PathVariable Long idNews) {
    return newsService.getNewsById(idNews);
  }

  @PostMapping("news")
  public News addNews(@RequestBody News news) {
    return newsService.addNews(news);
  }

  @PutMapping("news")
  public News updateNews(@RequestBody News news) {
    return newsService.addNews(news);
  }

  @PostMapping("getNewsBySlug")
  public NewsDetailPage getNewsBySlug(@RequestParam String slug) {
    return newsService.getNewsBySlug(slug);
  }

  @GetMapping("getBestNews")
  public List<News> getBestNews() {
    return newsService.getBestNews();
  }

  @GetMapping("getBestLoveNews")
  public List<News> getBestLoveNews() {
    return newsService.getBestLoveNews();
  }

  @PutMapping("updateViewNews")
  public int updateViewNews(@RequestParam String slug) {
    return newsService.updateViewNews(slug);
  }

  @GetMapping("getListNewsMostView")
  public List<News> getListNewsMostView() {
    return newsService.getListNewsMostView();
  }

  @GetMapping("getNewsPage")
  public NewsPage getNewsPage(){
    return newsService.getNewsPage();
  }

}
