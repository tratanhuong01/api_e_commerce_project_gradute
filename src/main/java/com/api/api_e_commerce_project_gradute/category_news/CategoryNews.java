package com.api.api_e_commerce_project_gradute.category_news;

import com.api.api_e_commerce_project_gradute.news.News;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category_news")
public class CategoryNews {
  @Id
  private String id;

  @OneToMany(mappedBy = "categoryNews",cascade = CascadeType.ALL)
  private Set<News> categoryNews = new HashSet<>();

  @Column
  private String nameCategoryNews;

  @Column
  private int typeCategoryNews;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameCategoryNews() {
    return nameCategoryNews;
  }

  public void setNameCategoryNews(String nameCategoryNews) {
    this.nameCategoryNews = nameCategoryNews;
  }

  public int getTypeCategoryNews() {
    return typeCategoryNews;
  }

  public void setTypeCategoryNews(int typeCategoryNews) {
    this.typeCategoryNews = typeCategoryNews;
  }
}
