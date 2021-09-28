package com.api.api_e_commerce_project_gradute.detail_function_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailFunctionProductService {

  @Autowired
  DetailFunctionProductRepository detailFunctionProductRepository;

  public List<DetailFunctionProduct> getAllDetailFunctionProducts() {
    return detailFunctionProductRepository.findAll();
  }

  public DetailFunctionProduct addDetailFunctionProduct(DetailFunctionProduct detailFunctionProduct) {
    return detailFunctionProductRepository.save(detailFunctionProduct);
  }

  public List<DetailFunctionProduct> getDetailFunctionProduct(String id) {
    return detailFunctionProductRepository.getDetailFunctionProductByLineProduct(id);
  }

}
