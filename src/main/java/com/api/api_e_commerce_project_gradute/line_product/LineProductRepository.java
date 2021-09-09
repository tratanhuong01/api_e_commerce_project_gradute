package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.Line;
import java.util.List;

@Repository
public interface LineProductRepository extends JpaRepository<LineProduct,String> {

  @Query(value = "SELECT * FROM line_product ORDER BY id DESC LIMIT 1 ",nativeQuery = true)
  LineProduct getIdBestNew();

  @Query(value = "SELECT * FROM line_product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<LineProduct> getAllLineProductLimit(int offset,int limit);

  @Query(value = "SELECT * FROM line_product WHERE id_group_product = ?1 ",nativeQuery = true)
  List<LineProduct> getLineProductByIdGroupProduct(String idGroupProduct);

  @Query(value = "SELECT DISTINCT line_product.id FROM line_product INNER JOIN group_product " +
      "ON line_product.id_group_product = group_product.id INNER JOIN category_product " +
      "ON group_product.id_category_product = category_product.id WHERE " +
      "line_product.name_line_product LIKE %:keyword% AND " +
      "category_product.id LIKE %:id% LIMIT 0 , 5 ",nativeQuery = true)
  List<String> searchProduct(String keyword,String id);


}
