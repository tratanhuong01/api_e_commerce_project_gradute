package com.api.api_e_commerce_project_gradute.category_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct,String> {

  @Query(value = "SELECT * FROM category_product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<CategoryProduct> getAllCategoryProductLimit(int offset,int limit);

}
