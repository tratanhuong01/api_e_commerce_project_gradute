package com.api.api_e_commerce_project_gradute.size;

import com.api.api_e_commerce_project_gradute.product_input.ProductInput;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "size")
public class Size {

  @Id
  private String id;

  @OneToMany(mappedBy = "sizeProduct")
  private Set<Size> sizeProduct = new HashSet<>();

  @Column
  private String sizeName;

  @Column
  private int isShow;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSizeName() {
    return sizeName;
  }

  public void setSizeName(String sizeName) {
    this.sizeName = sizeName;
  }

  public int getIsShow() {
    return isShow;
  }

  public void setIsShow(int isShow) {
    this.isShow = isShow;
  }
}
