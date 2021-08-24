package com.api.api_e_commerce_project_gradute.DTO.news;

import com.api.api_e_commerce_project_gradute.news.News;

import java.util.List;

public class NewsPage {
  private List<News> listSaleNewsMost;
  private List<NewsByCategory> listNewsByCategory;
  private List<News> listNewsMostView;
  private List<News> listAllNewsBestLimit;
  private int numberNews;

  public List<News> getListSaleNewsMost() {
    return listSaleNewsMost;
  }

  public void setListSaleNewsMost(List<News> listSaleNewsMost) {
    this.listSaleNewsMost = listSaleNewsMost;
  }

  public List<NewsByCategory> getListNewsByCategory() {
    return listNewsByCategory;
  }

  public void setListNewsByCategory(List<NewsByCategory> listNewsByCategory) {
    this.listNewsByCategory = listNewsByCategory;
  }

  public List<News> getListNewsMostView() {
    return listNewsMostView;
  }

  public void setListNewsMostView(List<News> listNewsMostView) {
    this.listNewsMostView = listNewsMostView;
  }

  public List<News> getListAllNewsBestLimit() {
    return listAllNewsBestLimit;
  }

  public void setListAllNewsBestLimit(List<News> listAllNewsBestLimit) {
    this.listAllNewsBestLimit = listAllNewsBestLimit;
  }

  public int getNumberNews() {
    return numberNews;
  }

  public void setNumberNews(int numberNews) {
    this.numberNews = numberNews;
  }
}
