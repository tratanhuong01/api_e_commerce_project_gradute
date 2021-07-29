package com.api.api_e_commerce_project_gradute.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "news")
public class News {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "newsDetail")
  private Set<NewsDetail> newsDetail = new HashSet<>();;

  @OneToMany(mappedBy = "newsComment")
  private Set<Comment> newsComment = new HashSet<>();;

  @OneToOne
  @JoinColumn(name = "id_user")
  private User userNews;

  @ManyToOne
  @JoinColumn(name = "id_category_news")
  private CategoryNews categoryNews;

  @Column
  private String title;

  @Column
  private String thumbnail;

  @Column
  private String describeSmall;

  @Column
  private Timestamp timeCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUserNews() {
    return userNews;
  }

  public void setUserNews(User userNews) {
    this.userNews = userNews;
  }

  public CategoryNews getCategoryNews() {
    return categoryNews;
  }

  public void setCategoryNews(CategoryNews categoryNews) {
    this.categoryNews = categoryNews;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getDescribeSmall() {
    return describeSmall;
  }

  public void setDescribeSmall(String describeSmall) {
    this.describeSmall = describeSmall;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
