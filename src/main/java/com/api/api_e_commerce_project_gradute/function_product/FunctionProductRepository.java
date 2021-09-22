package com.api.api_e_commerce_project_gradute.function_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionProductRepository extends JpaRepository<FunctionProduct,Long> {

  @Query(value = "SELECT * FROM function_product ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<FunctionProduct> getAllFunctionProductLimit(int offset,int limit);

  @Query(value = "SELECT * FROM function_product WHERE id_group_filter_product = ? ",nativeQuery = true)
  List<FunctionProduct> getFunctionProductById(Long id);

  @Query(value = "SELECT * FROM function_product WHERE id = ? ",nativeQuery = true)
  FunctionProduct getFunctionProductByIdFunctionProduct(Long id);

  @Query(value = "SELECT DISTINCT fp.id_group_filter_product FROM function_product fp " +
      "INNER JOIN group_filter_product gfp ON fp.id_group_filter_product = gfp.id INNER JOIN group_product gp " +
      "ON gfp.id_group_product = gp.id WHERE gp.slug_group_product = ?1 ",nativeQuery = true)
  List<Long> getFilterByGroupProduct(String slug);

  @Query(value = "SELECT fp.* FROM function_product fp " +
      "INNER JOIN group_filter_product gfp ON fp.id_group_filter_product = gfp.id INNER JOIN group_product gp " +
      "ON gfp.id_group_product = gp.id WHERE gp.slug_group_product = ?1 ",nativeQuery = true)
  List<FunctionProduct> getFunctionProductsBySlug(String slug);

  @Query(value = "SELECT * FROM function_product WHERE id = :keyword OR name_function_product LIKE CONCAT('%',:keyword,'%') " +
      "LIMIT :offset , :limit ",nativeQuery = true)
  List<FunctionProduct> searchFunctionProductLimit(@Param("keyword") String keyword, @Param("offset") int offset,
                                                 @Param("limit") int limit);

  @Query(value = "SELECT * FROM function_product WHERE id = :keyword OR name_function_product LIKE CONCAT('%',:keyword,'%') ",
      nativeQuery = true)
  List<FunctionProduct> searchFunctionProductAll(@Param("keyword") String keyword);

}
