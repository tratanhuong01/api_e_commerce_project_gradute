package com.api.api_e_commerce_project_gradute.news_detail;

import com.api.api_e_commerce_project_gradute.news.News;

import javax.persistence.*;

@Entity
@Table(name = "news_detail")
public class NewsDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_news")
  private News newsDetail;

  @Column
  private String image;

  @Column
  private String content;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public News getNewsDetail() {
    return newsDetail;
  }

  public void setNewsDetail(News newsDetail) {
    this.newsDetail = newsDetail;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
