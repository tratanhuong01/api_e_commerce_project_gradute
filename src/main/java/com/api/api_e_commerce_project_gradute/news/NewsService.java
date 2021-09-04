package com.api.api_e_commerce_project_gradute.news;

import com.api.api_e_commerce_project_gradute.DTO.comment.CommentLevel;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsByCategory;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsDetailPage;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsPage;
import com.api.api_e_commerce_project_gradute.category_news.CategoryNews;
import com.api.api_e_commerce_project_gradute.category_news.CategoryNewsRepository;
import com.api.api_e_commerce_project_gradute.comment.Comment;
import com.api.api_e_commerce_project_gradute.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

  public NewsPage getNewsPage() {
    NewsPage newsPage = new NewsPage();
    newsPage.setNumberNews(newsRepository.getNumberNews());
    newsPage.setListAllNewsBestLimit(newsRepository.getListAllNewsBestLimit(0,9));
    newsPage.setListNewsMostView(newsRepository.getListNewsMostView());
    newsPage.setListSaleNewsMost(newsRepository.getListNewsLimit("TINKHUYENMAI",0,3));

    List<NewsByCategory> newsByCategoryList = new ArrayList<>();

    List<CategoryNews> categoryNewsList = categoryNewsRepository.findAll();

    for (CategoryNews categoryNews : categoryNewsList) {
      NewsByCategory newsByCategory = new NewsByCategory();
      newsByCategory.setCategoryNews(categoryNews);
      newsByCategory.setNewsList(newsRepository.getListNewsLimit(categoryNews.getId(),0,3));
      newsByCategoryList.add(newsByCategory);
    }

    newsPage.setListNewsByCategory(newsByCategoryList);

    return newsPage;
  }

}
