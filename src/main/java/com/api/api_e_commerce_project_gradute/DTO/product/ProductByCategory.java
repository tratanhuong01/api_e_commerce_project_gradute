package com.api.api_e_commerce_project_gradute.DTO.product;

import java.util.List;

public class ProductByCategory {
  private String idCategoryProduct;
  private String nameCategoryProduct;
  private String slugCategoryProduct;
  private List<ProductFull> listProductCategory;

  public String getIdCategoryProduct() {
    return idCategoryProduct;
  }

  public void setIdCategoryProduct(String idCategoryProduct) {
    this.idCategoryProduct = idCategoryProduct;
  }

  public String getNameCategoryProduct() {
    return nameCategoryProduct;
  }

  public void setNameCategoryProduct(String nameCategoryProduct) {
    this.nameCategoryProduct = nameCategoryProduct;
  }

  public String getSlugCategoryProduct() {
    return slugCategoryProduct;
  }

  public void setSlugCategoryProduct(String slugCategoryProduct) {
    this.slugCategoryProduct = slugCategoryProduct;
  }

  public List<ProductFull> getListProductCategory() {
    return listProductCategory;
  }

  public void setListProductCategory(List<ProductFull> listProductCategory) {
    this.listProductCategory = listProductCategory;
  }
}
