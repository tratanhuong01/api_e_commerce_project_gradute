package com.api.api_e_commerce_project_gradute.function_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionProductRepository extends JpaRepository<FunctionProduct,Long> {

  @Query(value = "SELECT * FROM function_product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<FunctionProduct> getAllFunctionProductLimit(int offset,int limit);

  @Query(value = "SELECT * FROM function_product WHERE id_group_filter_product = ? ",nativeQuery = true)
  List<FunctionProduct> getFunctionProductById(String id);

  @Query(value = "SELECT DISTINCT fp.id_group_filter_product FROM function_product fp " +
      "INNER JOIN group_filter_product gfp ON fp.id_group_filter_product = gfp.id INNER JOIN group_product gp " +
      "ON gfp.id_group_product = gp.id WHERE gp.slug_group_product = ?1 ",nativeQuery = true)
  List<String> getFilterByGroupProduct(String slug);

  @Query(value = "SELECT fp.* FROM function_product fp " +
      "INNER JOIN group_filter_product gfp ON fp.id_group_filter_product = gfp.id INNER JOIN group_product gp " +
      "ON gfp.id_group_product = gp.id WHERE gp.slug_group_product = ?1 ",nativeQuery = true)
  List<FunctionProduct> getFunctionProductsBySlug(String slug);

}
