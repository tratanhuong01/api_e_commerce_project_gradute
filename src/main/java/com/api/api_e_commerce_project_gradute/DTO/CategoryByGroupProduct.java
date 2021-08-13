package com.api.api_e_commerce_project_gradute.DTO;

import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;

import java.util.List;

public class CategoryByGroupProduct {
  CategoryProduct categoryProduct;
  List<GroupProduct> groupProductList;

  public CategoryProduct getCategoryProduct() {
    return categoryProduct;
  }

  public void setCategoryProduct(CategoryProduct categoryProduct) {
    this.categoryProduct = categoryProduct;
  }

  public List<GroupProduct> getGroupProductList() {
    return groupProductList;
  }

  public void setGroupProductList(List<GroupProduct> groupProductList) {
    this.groupProductList = groupProductList;
  }
}
