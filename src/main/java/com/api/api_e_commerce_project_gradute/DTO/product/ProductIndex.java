package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.DTO.CategoryByGroupProduct;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import com.api.api_e_commerce_project_gradute.news.News;

import java.util.List;

public class ProductIndex {
  List<ProductFull> listProductTopSell;
  List<ProductFull> listProductSaleToday;
  List<ProductByCategory> listProductByCategory;
  List<CategoryByGroupProduct> listCategoryByGroupProduct;
  List<News> newsList;

  public List<News> getNewsList() {
    return newsList;
  }

  public void setNewsList(List<News> newsList) {
    this.newsList = newsList;
  }

  public List<ProductFull> getListProductTopSell() {
    return listProductTopSell;
  }

  public void setListProductTopSell(List<ProductFull> listProductTopSell) {
    this.listProductTopSell = listProductTopSell;
  }

  public List<ProductFull> getListProductSaleToday() {
    return listProductSaleToday;
  }

  public void setListProductSaleToday(List<ProductFull> listProductSaleToday) {
    this.listProductSaleToday = listProductSaleToday;
  }

  public List<ProductByCategory> getListProductByCategory() {
    return listProductByCategory;
  }

  public void setListProductByCategory(List<ProductByCategory> listProductByCategory) {
    this.listProductByCategory = listProductByCategory;
  }

  public List<CategoryByGroupProduct> getListCategoryByGroupProduct() {
    return listCategoryByGroupProduct;
  }

  public void setListCategoryByGroupProduct(List<CategoryByGroupProduct> listCategoryByGroupProduct) {
    this.listCategoryByGroupProduct = listCategoryByGroupProduct;
  }
}
