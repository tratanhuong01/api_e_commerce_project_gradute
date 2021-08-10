package com.api.api_e_commerce_project_gradute.DTO.product;

import java.util.List;

public class ProductIndex {
  List<ProductFull> listProductTopSell;
  List<ProductFull> listProductSaleToday;
  List<ProductByCategory> listProductByCategory;

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
}
