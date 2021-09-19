package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupProductRepository extends JpaRepository<GroupProduct,String> {

  @Query(value = "SELECT * FROM group_product WHERE id_category_product = ?1 ",nativeQuery = true)
  List<GroupProduct> getGroupProductByIdCategoryProduct(String idCategoryProduct);

  @Query(value = "SELECT * FROM group_product gp INNER JOIN category_product ct ON gp.id_category_product = " +
      " ct.id  WHERE ct.slug_category_product = ?1 ",nativeQuery = true)
  List<GroupProduct> getGroupProductBySlugCategoryProduct(String slugCategoryProduct);

  @Query(value = "SELECT * FROM group_product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<GroupProduct> getAllGroupProductLimit(int offset,int limit);

}
