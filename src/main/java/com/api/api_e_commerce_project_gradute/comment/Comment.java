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

  @Column
  private String fullName;

  @Column
  private String email;

  @Column
  private int level;

  @Column
  private Long reply;

  @ManyToOne
  @JoinColumn(name = "id_news")
  private News commentNews;

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

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public Long getReply() {
    return reply;
  }

  public void setReply(Long reply) {
    this.reply = reply;
  }

  public News getCommentNews() {
    return commentNews;
  }

  public void setCommentNews(News commentNews) {
    this.commentNews = commentNews;
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

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
