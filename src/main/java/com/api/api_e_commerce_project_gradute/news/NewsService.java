package com.api.api_e_commerce_project_gradute.news;

import com.api.api_e_commerce_project_gradute.DTO.comment.CommentLevel;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsByCategory;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsDetailPage;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsPage;
import com.api.api_e_commerce_project_gradute.DTO.specification.news.NewsCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.news.NewsSpecification;
import com.api.api_e_commerce_project_gradute.category_news.CategoryNews;
import com.api.api_e_commerce_project_gradute.category_news.CategoryNewsRepository;
import com.api.api_e_commerce_project_gradute.comment.Comment;
import com.api.api_e_commerce_project_gradute.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

  @Autowired
  NewsRepository newsRepository;

  @Autowired
  CategoryNewsRepository categoryNewsRepository;

  @Autowired
  CommentRepository commentRepository;

  public List<News> getNewsLimit(int offset,int limit) {
    return newsRepository.getNewsLimit(offset, limit);
  }

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

  public News updateNews(News news) {
    return newsRepository.save(news);
  }

  public NewsDetailPage getNewsBySlug(String slug) {
    News news =  newsRepository.getNewsBySlug(slug);
    NewsDetailPage newsDetailPage = new NewsDetailPage();
    newsDetailPage.setNews(news);
    newsDetailPage.setNewsBestList(newsRepository.getBestNewsIndex());
    newsDetailPage.setNewsBestLoveList(newsRepository.getBestLoveNews());
    newsDetailPage.setNewsSameList(newsRepository.getListNewsSame(news.getCategoryNews().getId(),news.getId()));
    return newsDetailPage;
  }

  public List<News> getBestNews() {
    return newsRepository.getBestNewsIndex();
  }

  public List<News> getBestLoveNews() {
    return newsRepository.getBestLoveNews();
  }

  public int updateViewNews(String slug) {
    return newsRepository.updateViewNews(slug);
  }

  public List<News> getListNewsMostView() {
    return newsRepository.getListNewsMostView();
  }

  public Integer getNewsBestsAll() {
    return newsRepository.findAll().size();
  }

  public List<News> getNewsBestsLimit(int offset,int limit) {
    Pageable pageable = PageRequest.of(offset, limit, Sort.by("timeCreated").descending());
    Page<News> newsPage = newsRepository.findAll(pageable);
    return newsPage.getContent();
  }

  public List<News> getNewsMostView() {
    return newsRepository.getListNewsMostView();
  }

  public Integer getNewsByCategoryAll(String idCategoryNews) {
    return newsRepository.getListNewsByCategoryAll(idCategoryNews).size();
  }

  public List<News> getNewsByCategoryLimit(String idCategoryNews,int offset,int limit) {
    return newsRepository.getListNewsByCategoryLimit(idCategoryNews,offset,limit);
  }

  public Integer getNewsAllAdmin(NewsCriteria newsCriteria) {
    Specification<News> newsSpecification = NewsSpecification.createNewsSpecification(newsCriteria);
    return newsRepository.findAll(newsSpecification).size();
  }

  public List<News> getNewsLimitAdmin(NewsCriteria newsCriteria) {
    Specification<News> newsSpecification = NewsSpecification.createNewsSpecification(newsCriteria);
    Pageable pageable = PageRequest.of(newsCriteria.getOffset(),newsCriteria.getLimit());
    Page<News> newsPage = newsRepository.findAll(newsSpecification,pageable);
    return newsPage.getContent();
  }

  public void deleteNews(News news) {
    newsRepository.delete(news);
  }
}
