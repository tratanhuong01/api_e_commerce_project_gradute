package com.api.api_e_commerce_project_gradute.category_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct,String> {

  @Query(value = "SELECT * FROM category_product ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<CategoryProduct> getAllCategoryProductLimit(int offset,int limit);

  @Query(value = "SELECT * FROM category_product WHERE id = :keyword OR name_category_product LIKE CONCAT('%',:keyword,'%') " +
      "LIMIT :offset , :limit ",nativeQuery = true)
  List<CategoryProduct> searchCategoryProductLimit(@Param("keyword") String keyword,@Param("offset") int offset,
                                                   @Param("limit") int limit);

  @Query(value = "SELECT * FROM category_product WHERE id = :keyword OR name_category_product LIKE CONCAT('%',:keyword,'%') ",
      nativeQuery = true)
  List<CategoryProduct> searchCategoryProductAll(@Param("keyword") String keyword);

}
