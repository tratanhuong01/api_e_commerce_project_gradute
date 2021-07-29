package com.api.api_e_commerce_project_gradute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group_product")
public class GroupProduct {
  @Id
  private String id;

  @Column
  private String nameGroupProduct;

  @Column
  private int typeGroupProduct;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameGroupProduct() {
    return nameGroupProduct;
  }

  public void setNameGroupProduct(String nameGroupProduct) {
    this.nameGroupProduct = nameGroupProduct;
  }

  public int getTypeGroupProduct() {
    return typeGroupProduct;
  }

  public void setTypeGroupProduct(int typeGroupProduct) {
    this.typeGroupProduct = typeGroupProduct;
  }
}
