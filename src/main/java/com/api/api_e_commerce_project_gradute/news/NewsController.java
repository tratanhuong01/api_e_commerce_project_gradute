package com.api.api_e_commerce_project_gradute.news;

import com.api.api_e_commerce_project_gradute.DTO.news.NewsDetailPage;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsPage;
import com.api.api_e_commerce_project_gradute.DTO.specification.news.NewsCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class  NewsController {

  @Autowired
  NewsService newsService;

  //filter admin
  @GetMapping("newFiltersAll")
  public Integer getAllNewsAdmin(String category,String poster,String viewSorter,String commentSorter,
                                 String keyword,String timeCreatedFrom , String timeCreatedTo) {
    NewsCriteria newsCriteria = NewsCriteria.builder()
        .category(category)
        .poster(poster)
        .viewSorter(viewSorter)
        .commentSorter(commentSorter)
        .keyword(keyword)
        .timeCreatedFrom(timeCreatedFrom)
        .timeCreatedTo(timeCreatedTo)
        .build();
    return newsService.getNewsAllAdmin(newsCriteria);
  }

  @GetMapping("newFilters")
  public List<News> getLimitNewsAdmin(String category,String poster,String viewSorter,String commentSorter,
                                      Integer offset,Integer limit,String keyword,String timeCreatedTo,
                                      String timeCreatedFrom) {
    NewsCriteria newsCriteria = NewsCriteria.builder()
        .category(category)
        .poster(poster)
        .timeCreatedFrom(timeCreatedFrom)
        .timeCreatedTo(timeCreatedTo)
        .viewSorter(viewSorter)
        .commentSorter(commentSorter)
        .offset(offset)
        .limit(limit)
        .keyword(keyword)
        .build();
    return newsService.getNewsLimitAdmin(newsCriteria);
  }

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
    return newsService.updateNews(news);
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

  @GetMapping("newsPaginationAll")
  public Integer getNewsBestsAll() {
    return newsService.getNewsBestsAll();
  }

  @GetMapping("newsPagination")
  public List<News> getNewsBestsLimit(Integer offset , Integer limit) {
    return newsService.getNewsBestsLimit(offset,limit);
  }

  @GetMapping("news/categoryNewsAll")
  public Integer getNewsByCategoryAll(String idCategoryNews) {
    return newsService.getNewsByCategoryAll(idCategoryNews);
  }

  @GetMapping("news/categoryNews")
  public List<News> getNewsByCategoryLimit(String idCategoryNews ,Integer offset , Integer limit) {
    return newsService.getNewsByCategoryLimit(idCategoryNews,offset,limit);
  }

  //delete
  @DeleteMapping("news")
  public void deleteNews(@RequestBody News news) {
    newsService.deleteNews(news);
  }

  @PostMapping("getNewsByIdCategory")
  public List<News> getNewsByIdCategory(@RequestBody String idCategoryNews) {
    return newsService.getNewsByIdCategory(idCategoryNews);
  }

}
