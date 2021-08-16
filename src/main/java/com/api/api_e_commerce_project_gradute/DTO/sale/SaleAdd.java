package com.api.api_e_commerce_project_gradute.DTO.sale;

import com.api.api_e_commerce_project_gradute.sale.Sale;

public class SaleAdd {
  private Sale sale;
  private String id;

  public Sale getSale() {
    return sale;
  }

  public void setSale(Sale sale) {
    this.sale = sale;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
