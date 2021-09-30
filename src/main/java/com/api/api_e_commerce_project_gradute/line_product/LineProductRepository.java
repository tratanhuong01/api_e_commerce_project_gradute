package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.util.List;

@Repository
public interface LineProductRepository extends JpaRepository<LineProduct,String> {

  List<LineProduct> findAll(@Nullable Specification<LineProduct> lineProductSpecification);

  Page<LineProduct> findAll(@Nullable Specification<LineProduct> lineProductSpecification, Pageable pageable);

  @Query(value = "SELECT * FROM line_product ORDER BY id DESC LIMIT 1 ",nativeQuery = true)
  LineProduct getIdBestNew();

  @Query(value = "SELECT * FROM line_product  ",nativeQuery = true)
  List<LineProduct> getAllLineProduct();

  @Query(value = "SELECT * FROM line_product ORDER BY time_created DESC LIMIT ?1 , ?2  ",nativeQuery = true)
  List<LineProduct> getAllLineProductLimit(int offset,int limit);

  @Query(value = "SELECT * FROM line_product WHERE id_group_product = ?1 ",nativeQuery = true)
  List<LineProduct> getLineProductByIdGroupProduct(String idGroupProduct);

  @Query(value = "SELECT DISTINCT line_product.id FROM line_product INNER JOIN group_product " +
      "ON line_product.id_group_product = group_product.id INNER JOIN category_product " +
      "ON group_product.id_category_product = category_product.id WHERE " +
      "line_product.name_line_product LIKE %:keyword% AND " +
      "category_product.slug_category_product LIKE %:id% ",nativeQuery = true)
  List<String> searchProduct(String keyword,String id);

  @Query(value = "SELECT DISTINCT line_product.id FROM line_product INNER JOIN group_product " +
      "ON line_product.id_group_product = group_product.id INNER JOIN category_product " +
      "ON group_product.id_category_product = category_product.id WHERE " +
      "line_product.name_line_product LIKE %:keyword% AND " +
      "category_product.slug_category_product LIKE %:id% LIMIT :offset , :limit ",nativeQuery = true)
  List<String> searchProductLimit(String keyword,String id,int offset, int limit);

  @Query(value = "SELECT * FROM line_product WHERE id = :keyword OR name_line_product LIKE CONCAT('%',:keyword,'%')" +
      " LIMIT :offset , :limit ",nativeQuery = true)
  List<LineProduct> searchLineProductLimit(@Param("keyword") String keyword, @Param("offset") int offset,
                                             @Param("limit") int limit);

  @Query(value = "SELECT * FROM line_product WHERE id = :keyword OR name_line_product LIKE CONCAT('%',:keyword,'%') ",
      nativeQuery = true)
  List<LineProduct> searchLineProductAll(@Param("keyword") String keyword);

}
