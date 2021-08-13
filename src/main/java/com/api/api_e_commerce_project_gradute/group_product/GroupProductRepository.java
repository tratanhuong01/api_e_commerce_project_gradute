package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupProductRepository extends JpaRepository<GroupProduct,String> {

  @Query(value = "SELECT * FROM group_product WHERE id_category_product = ?1 ",nativeQuery = true)
  List<GroupProduct> getGroupProductByIdCategoryProduct(String idCategoryProduct);

}
