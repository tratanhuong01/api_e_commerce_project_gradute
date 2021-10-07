package com.api.api_e_commerce_project_gradute.banner_index;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "banner_index")

public class BannerIndex {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String imageLeft;

  @Column
  private String imageRight;

  @Column
  private Timestamp timeCreated;

  @Column
  private int isShow;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getImageLeft() {
    return imageLeft;
  }

  public void setImageLeft(String imageLeft) {
    this.imageLeft = imageLeft;
  }

  public String getImageRight() {
    return imageRight;
  }

  public void setImageRight(String imageRight) {
    this.imageRight = imageRight;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public int getIsShow() {
    return isShow;
  }

  public void setIsShow(int isShow) {
    this.isShow = isShow;
  }
}
