package com.api.api_e_commerce_project_gradute.ram;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ram")
public class Ram {

  @Id
  private String id;

  @OneToMany(mappedBy = "ramProduct")
  private Set<Ram> ramProduct = new HashSet<>();

  @Column
  private String nameRam;

  @Column
  private int isShow;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameRam() {
    return nameRam;
  }

  public void setNameRam(String nameRam) {
    this.nameRam = nameRam;
  }

  public int getIsShow() {
    return isShow;
  }

  public void setIsShow(int isShow) {
    this.isShow = isShow;
  }
}
