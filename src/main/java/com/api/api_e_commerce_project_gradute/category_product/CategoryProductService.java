package com.api.api_e_commerce_project_gradute.category_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductService {

  @Autowired
  CategoryProductRepository categoryProductRepository;

  public List<CategoryProduct> getAllCategoryProducts() {
    return categoryProductRepository.findAll();
  }

  public Optional<CategoryProduct> getCategoryProductById(String idCategoryProduct) {
    return categoryProductRepository.findById(idCategoryProduct);
  }

  public CategoryProduct addCategoryProduct(CategoryProduct categoryProduct) {
    return categoryProductRepository.save(categoryProduct);
  }

  public List<CategoryProduct> getAllCategoryProductLimit(int offset,int limit) {
    return categoryProductRepository.getAllCategoryProductLimit(offset, limit);
  }

  public List<CategoryProduct> searchCategoryProductAll(String keyword) {
    return categoryProductRepository.searchCategoryProductAll(keyword);
  }

  public List<CategoryProduct> searchCategoryProductLimit(String keyword,int offset,int limit) {
    return categoryProductRepository.searchCategoryProductLimit(keyword,offset,limit);
  }

  public void deleteCategoryProduct(CategoryProduct categoryProduct) {
    categoryProductRepository.delete(categoryProduct);
  }

}
