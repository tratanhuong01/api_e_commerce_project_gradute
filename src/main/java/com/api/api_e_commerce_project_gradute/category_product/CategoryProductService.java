package com.api.api_e_commerce_project_gradute.category_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductService {

  @Autowired
  CategoryProductRepository categoryProductRepository;

  public List<CategoryProduct> getAllCategoryProducts() {
    return categoryProductRepository.findAll();
  }

  public CategoryProduct getCategoryProductById(String idCategoryProduct) {
    return categoryProductRepository.getById(idCategoryProduct);
  }

  public CategoryProduct addCategoryProduct(CategoryProduct categoryProduct) {
    return categoryProductRepository.save(categoryProduct);
  }

}
