package com.api.api_e_commerce_project_gradute.attribute_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeProductRepository extends JpaRepository<AttributeProduct,Long> {

  @Query(value = "SELECT * FROM attribute_product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<AttributeProduct> getAllAttributeProductLimit(int offset,int limit);

  @Query(value = "SELECT DISTINCT ga.id FROM attribute_product ap INNER JOIN attribute a " +
      "ON ap.id_attribute = a.id INNER JOIN group_attribute ga ON a.id_group_attribute = ga.id " +
      "INNER JOIN line_product lp ON ap.id_line_product = lp.id WHERE lp.id = ?1 ",nativeQuery = true)
  List<String> getDistinctGroupAttributeByIdLineProduct(String idLineProduct);

  @Query(value = "SELECT ap.* FROM attribute_product ap INNER JOIN attribute a " +
      "ON ap.id_attribute = a.id INNER JOIN group_attribute ga ON a.id_group_attribute = ga.id " +
      "INNER JOIN line_product lp ON ap.id_line_product = lp.id WHERE lp.id = ?1 AND a.id_group_attribute = ?2 " +
      "ORDER BY a.name_attribute ASC ",nativeQuery = true)
  List<AttributeProduct> getAttributeProductByIdLineProductAndGroupAttribute(String idLineProduct,String idGroupAttribute);

}
