package com.api.api_e_commerce_project_gradute.DTO.news;

import com.api.api_e_commerce_project_gradute.DTO.comment.CommentLevel;
import com.api.api_e_commerce_project_gradute.news.News;

import java.util.List;

public class NewsDetailPage {
  private News news;
  private List<CommentLevel> commentLevelList;
  private List<News> newsBestList;
  private List<News> newsBestLoveList;
  private List<News> newsSameList;

  public List<News> getNewsSameList() {
    return newsSameList;
  }

  public void setNewsSameList(List<News> newsSameList) {
    this.newsSameList = newsSameList;
  }

  public News getNews() {
    return news;
  }

  public void setNews(News news) {
    this.news = news;
  }

  public List<CommentLevel> getCommentLevelList() {
    return commentLevelList;
  }

  public void setCommentLevelList(List<CommentLevel> commentLevelList) {
    this.commentLevelList = commentLevelList;
  }

  public List<News> getNewsBestList() {
    return newsBestList;
  }

  public void setNewsBestList(List<News> newsBestList) {
    this.newsBestList = newsBestList;
  }

  public List<News> getNewsBestLoveList() {
    return newsBestLoveList;
  }

  public void setNewsBestLoveList(List<News> newsBestLoveList) {
    this.newsBestLoveList = newsBestLoveList;
  }
}
