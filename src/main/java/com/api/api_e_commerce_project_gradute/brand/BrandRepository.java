package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,String> {

  @Query(value = "SELECT * FROM brand WHERE id = ?1 ",nativeQuery = true)
  Brand getBrandByIdBrand(String idBrand);

  @Query(value = "SELECT * FROM brand ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Brand> getBrandsLimit(int offset,int limit);

  @Query(value = "SELECT id_brand from line_product INNER JOIN group_product ON group_product.id = " +
      "line_product.id_group_product WHERE group_product.slug_group_product = ? ",nativeQuery = true)
  List<String> getBrandBySlugGroupProduct(String slugGroupProduct);

  @Query(value = "SELECT * FROM brand WHERE id = :keyword OR name_brand LIKE CONCAT('%',:keyword,'%') " +
      "LIMIT :offset , :limit ",nativeQuery = true)
  List<Brand> searchBrandLimit(@Param("keyword") String keyword, @Param("offset") int offset,
                                                   @Param("limit") int limit);

  @Query(value = "SELECT * FROM brand WHERE id = :keyword OR name_brand LIKE CONCAT('%',:keyword,'%') ",
      nativeQuery = true)
  List<Brand> searchBrandAll(@Param("keyword") String keyword);

}
