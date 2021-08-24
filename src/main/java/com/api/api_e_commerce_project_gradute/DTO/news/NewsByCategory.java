package com.api.api_e_commerce_project_gradute.DTO.news;

import com.api.api_e_commerce_project_gradute.category_news.CategoryNews;
import com.api.api_e_commerce_project_gradute.news.News;

import java.util.List;

public class NewsByCategory {
  private CategoryNews categoryNews;
  private List<News> newsList;

  public CategoryNews getCategoryNews() {
    return categoryNews;
  }

  public void setCategoryNews(CategoryNews categoryNews) {
    this.categoryNews = categoryNews;
  }

  public List<News> getNewsList() {
    return newsList;
  }

  public void setNewsList(List<News> newsList) {
    this.newsList = newsList;
  }
}
