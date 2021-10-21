package com.api.api_e_commerce_project_gradute.notify;

import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notify")

public class Notify {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User userNotify;

  @Column
  private String nameNotify;

  @Column
  private String data;

  @Column
  private String image;

  @Column
  private String description;

  @Column
  private Timestamp timeCreated;

  @Column
  private Integer isRead;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Integer getIsRead() {
    return isRead;
  }

  public void setIsRead(Integer isRead) {
    this.isRead = isRead;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUserNotify() {
    return userNotify;
  }

  public void setUserNotify(User userNotify) {
    this.userNotify = userNotify;
  }

  public String getNameNotify() {
    return nameNotify;
  }

  public void setNameNotify(String nameNotify) {
    this.nameNotify = nameNotify;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
