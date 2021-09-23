package com.api.api_e_commerce_project_gradute.DTO.specification.user;

import com.api.api_e_commerce_project_gradute.user.User;

public class UserFull extends User {

  public UserFull() {
    super();
  }

  private Integer amountOrder;
  private Integer amountProduct;

  public Integer getAmountProduct() {
    return amountProduct;
  }

  public void setAmountProduct(Integer amountProduct) {
    this.amountProduct = amountProduct;
  }

  public int getAmountOrder() {
    return amountOrder;
  }

  public void setAmountOrder(Integer amountOrder) {
    this.amountOrder = amountOrder;
  }

}
