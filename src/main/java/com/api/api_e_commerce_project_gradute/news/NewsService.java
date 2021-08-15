package com.api.api_e_commerce_project_gradute.news;

import com.api.api_e_commerce_project_gradute.DTO.comment.CommentLevel;
import com.api.api_e_commerce_project_gradute.DTO.news.NewsDetailPage;
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
  CommentRepository commentRepository;

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
    List<Comment> commentList = commentRepository.getListCommentLevelOneByIdNews(news.getId());
    List<CommentLevel> commentLevelList = new ArrayList<>();
    for (Comment comment: commentList) {
      CommentLevel commentLevel = new CommentLevel();
      commentLevel.setComment(comment);
      commentLevel.setCommentList(commentRepository.getListCommentLevelTwoByIdNews(comment.getId()));
      commentLevelList.add(commentLevel);
    }
    newsDetailPage.setCommentLevelList(commentLevelList);
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

}
