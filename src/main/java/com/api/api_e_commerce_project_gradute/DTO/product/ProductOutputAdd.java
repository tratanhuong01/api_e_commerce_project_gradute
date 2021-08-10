package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.product_output.ProductOutput;

public class ProductOutputAdd {
  private ProductOutput productOutput;
  private String id;

  public ProductOutput getProductOutput() {
    return productOutput;
  }

  public void setProductOutput(ProductOutput productOutput) {
    this.productOutput = productOutput;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
