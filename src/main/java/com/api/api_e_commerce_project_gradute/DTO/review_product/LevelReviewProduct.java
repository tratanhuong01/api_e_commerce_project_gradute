package com.api.api_e_commerce_project_gradute.DTO.review_product;

import com.api.api_e_commerce_project_gradute.review_product.ReviewProduct;

import java.util.List;

public class LevelReviewProduct {
  private ReviewProduct reviewProduct;
  private List<ReviewProduct> reviewProductList;

  public ReviewProduct getReviewProduct() {
    return reviewProduct;
  }

  public void setReviewProduct(ReviewProduct reviewProduct) {
    this.reviewProduct = reviewProduct;
  }

  public List<ReviewProduct> getReviewProductList() {
    return reviewProductList;
  }

  public void setReviewProductList(List<ReviewProduct> reviewProductList) {
    this.reviewProductList = reviewProductList;
  }
}
