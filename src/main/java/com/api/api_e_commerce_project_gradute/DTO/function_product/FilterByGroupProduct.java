package com.api.api_e_commerce_project_gradute.DTO.function_product;

import com.api.api_e_commerce_project_gradute.function_product.FunctionProduct;
import com.api.api_e_commerce_project_gradute.group_filter_product.GroupFilterProduct;

import java.util.List;

public class FilterByGroupProduct {
  private GroupFilterProduct groupFilterProduct;
  private List<FunctionProduct> functionProductList;

  public GroupFilterProduct getGroupFilterProduct() {
    return groupFilterProduct;
  }

  public void setGroupFilterProduct(GroupFilterProduct groupFilterProduct) {
    this.groupFilterProduct = groupFilterProduct;
  }

  public List<FunctionProduct> getFunctionProductList() {
    return functionProductList;
  }

  public void setFunctionProductList(List<FunctionProduct> functionProductList) {
    this.functionProductList = functionProductList;
  }
}
