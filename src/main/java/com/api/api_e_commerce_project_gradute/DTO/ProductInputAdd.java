package com.api.api_e_commerce_project_gradute.DTO;

import com.api.api_e_commerce_project_gradute.product_input.ProductInput;

public class ProductInputAdd {
  private ProductInput productInput;
  private String id;

  public ProductInput getProductInput() {
    return productInput;
  }

  public void setProductInput(ProductInput productInput) {
    this.productInput = productInput;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
