package com.api.api_e_commerce_project_gradute.function_product;

import com.api.api_e_commerce_project_gradute.DTO.function_product.FilterByGroupProduct;
import com.api.api_e_commerce_project_gradute.group_filter_product.GroupFilterProduct;
import com.api.api_e_commerce_project_gradute.group_filter_product.GroupFilterProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionProductService {

  @Autowired
  FunctionProductRepository functionProductRepository;

  @Autowired
  GroupFilterProductRepository groupFilterProductRepository;

  public List<FunctionProduct> getAllFunctionProducts() {
    return functionProductRepository.findAll();
  }

  public List<FunctionProduct> getAllFunctionProductLimit(int offset,int limit) {
    return functionProductRepository.getAllFunctionProductLimit(offset, limit);
  }

  public List<FunctionProduct> addFunctionProduct(FunctionProduct functionProduct) {
    functionProductRepository.save(functionProduct);
    return functionProductRepository.findAll();
  }

  public List<FilterByGroupProduct> getFilterByGroupProduct(String slug) {
    List<Long> longList =  functionProductRepository.getFilterByGroupProduct(slug);
    List<FilterByGroupProduct> filterByGroupProductList = new ArrayList<>();

    for (Long data : longList) {
      FilterByGroupProduct filterByGroupProduct = new FilterByGroupProduct();
      filterByGroupProduct.setGroupFilterProduct(
          groupFilterProductRepository.getGroupFilterProductById(data)
      );
      filterByGroupProduct.setFunctionProductList(
          functionProductRepository.getFunctionProductById(data)
      );
      filterByGroupProductList.add(filterByGroupProduct);
    }

    return filterByGroupProductList;
  }

  public List<FunctionProduct> getFunctionProductsBySlug(String slug) {
    return functionProductRepository.getFunctionProductsBySlug(slug);
  }

}
