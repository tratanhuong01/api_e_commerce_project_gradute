package com.api.api_e_commerce_project_gradute.attribute_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeProductRepository extends JpaRepository<AttributeProduct,Long> {

  @Query(value = "SELECT * FROM attribute_product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<AttributeProduct> getAllAttributeProductLimit(int offset,int limit);

}
