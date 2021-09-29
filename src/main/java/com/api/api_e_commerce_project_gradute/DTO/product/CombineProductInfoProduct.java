package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.info_product.InfoProduct;
import com.api.api_e_commerce_project_gradute.product.Product;

public class CombineProductInfoProduct {
  private Product product;
  private InfoProduct infoProduct;

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public InfoProduct getInfoProduct() {
    return infoProduct;
  }

  public void setInfoProduct(InfoProduct infoProduct) {
    this.infoProduct = infoProduct;
  }
}
