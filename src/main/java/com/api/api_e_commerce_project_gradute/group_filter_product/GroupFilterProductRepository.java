package com.api.api_e_commerce_project_gradute.group_filter_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupFilterProductRepository extends JpaRepository<GroupFilterProduct,Long> {

  @Query(value = "SELECT * FROM group_filter_product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<GroupFilterProduct> getAllGroupFilterProductLimit(int offset, int limit);

  @Query(value = "SELECT * FROM group_filter_product WHERE id = ?1 ",nativeQuery = true)
  GroupFilterProduct getGroupFilterProductById(Long id);

}
