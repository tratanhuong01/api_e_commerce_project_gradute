package com.api.api_e_commerce_project_gradute.detail_function_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailFunctionProductRepository extends JpaRepository<DetailFunctionProduct,Long> {

  @Query(value = "SELECT * FROM detail_function_product WHERE id_function_product = ?1 AND id_line_product = ?2 ",nativeQuery = true)
  DetailFunctionProduct getDetailFunctionProduct(Long idFunctionProduct,String idLineProduct);

  @Query(value = "SELECT * FROM detail_function_product WHERE id_line_product = ?1 ",nativeQuery = true)
  List<DetailFunctionProduct> getDetailFunctionProductByLineProduct(String idLineProduct);

}
