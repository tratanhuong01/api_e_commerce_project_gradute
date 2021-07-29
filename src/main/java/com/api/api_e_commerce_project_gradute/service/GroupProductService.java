package com.api.api_e_commerce_project_gradute.service;

import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;

@Service
public class GroupProductService {
  @Id
  private String idGroupProduct;

  @Column
  private String nameGroupProduct;

  @Column
  private int typeGroupProduct;

  public String getIdGroupProduct() {
    return idGroupProduct;
  }

  public void setIdGroupProduct(String idGroupProduct) {
    this.idGroupProduct = idGroupProduct;
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
