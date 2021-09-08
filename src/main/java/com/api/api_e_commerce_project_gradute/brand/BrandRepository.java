package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,String> {

  @Query(value = "SELECT * FROM brand WHERE id = ?1 ",nativeQuery = true)
  Brand getBrandByIdBrand(String idBrand);

  @Query(value = "SELECT * FROM brand LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Brand> getBrandsLimit(int offset,int limit);

  @Query(value = "SELECT DISTINCT id_brand from product INNER JOIN line_product ON product.id_line_product = " +
      "line_product.id INNER JOIN group_product ON group_product.id = line_product.id_group_product " +
      "WHERE group_product.slug_group_product = ? ",nativeQuery = true)
  List<String> getBrandBySlugGroupProduct(String slugGroupProduct);

}
