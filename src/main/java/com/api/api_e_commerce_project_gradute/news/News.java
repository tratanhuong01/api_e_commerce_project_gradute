package com.api.api_e_commerce_project_gradute.news;

import com.api.api_e_commerce_project_gradute.category_news.CategoryNews;
import com.api.api_e_commerce_project_gradute.comment.Comment;
import com.api.api_e_commerce_project_gradute.user.User;

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

  @OneToMany(mappedBy = "commentNews")
  private Set<Comment> commentNews = new HashSet<>();;

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

  @Column
  private int view;

  @Column
  private String content;

  @Column
  private String slug;

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getView() {
    return view;
  }

  public void setView(int view) {
    this.view = view;
  }

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
