package com.api.api_e_commerce_project_gradute.comment;

import com.api.api_e_commerce_project_gradute.news.News;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User commentUser;

  @ManyToOne
  @JoinColumn(name = "id_news")
  private News newsComment;

  @Column
  private String content;

  @Column
  private Timestamp timeCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getCommentUser() {
    return commentUser;
  }

  public void setCommentUser(User commentUser) {
    this.commentUser = commentUser;
  }

  public News getNewsComment() {
    return newsComment;
  }

  public void setNewsComment(News newsComment) {
    this.newsComment = newsComment;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
