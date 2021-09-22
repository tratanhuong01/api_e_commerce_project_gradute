package com.api.api_e_commerce_project_gradute.group_filter_product;

import com.api.api_e_commerce_project_gradute.function_product.FunctionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupFilterProductRepository extends JpaRepository<GroupFilterProduct,Long> {

  @Query(value = "SELECT * FROM group_filter_product ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<GroupFilterProduct> getAllGroupFilterProductLimit(int offset, int limit);

  @Query(value = "SELECT * FROM group_filter_product WHERE id = ?1 ",nativeQuery = true)
  GroupFilterProduct getGroupFilterProductById(Long id);

  @Query(value = "SELECT * FROM group_filter_product WHERE id = :keyword OR name_group_filter_product LIKE CONCAT('%',:keyword,'%') " +
      "LIMIT :offset , :limit ",nativeQuery = true)
  List<GroupFilterProduct> searchGroupFilterProductLimit(@Param("keyword") String keyword, @Param("offset") int offset,
                                                   @Param("limit") int limit);

  @Query(value = "SELECT * FROM group_filter_product WHERE id = :keyword OR name_group_filter_product LIKE CONCAT('%',:keyword,'%') ",
      nativeQuery = true)
  List<GroupFilterProduct> searchGroupFilterProductAll(@Param("keyword") String keyword);

}
