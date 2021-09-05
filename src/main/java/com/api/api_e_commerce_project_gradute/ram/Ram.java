package com.api.api_e_commerce_project_gradute.ram;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ram")
public class Ram {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "ramProduct")
  private Set<Ram> ramProduct = new HashSet<>();

  @Column
  private String nameRam;

  @Column
  private int isShow;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
