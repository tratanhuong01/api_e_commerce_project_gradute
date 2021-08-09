package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LineProductRepository extends JpaRepository<LineProduct,String> {

  @Query(value = "SELECT * FROM line_product ORDER BY id DESC LIMIT 1 ",nativeQuery = true)
  LineProduct getIdBestNew();

}
