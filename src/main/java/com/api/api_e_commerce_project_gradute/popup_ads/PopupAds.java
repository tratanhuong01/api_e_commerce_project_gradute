package com.api.api_e_commerce_project_gradute.popup_ads;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "popup_ads")

public class PopupAds {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String image;

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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
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
