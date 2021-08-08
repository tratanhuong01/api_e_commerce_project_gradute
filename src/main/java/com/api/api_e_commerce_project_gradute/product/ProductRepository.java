package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

  @Query(value = "SELECT * FROM product ORDER BY id DESC LIMIT 1",nativeQuery = true)
  Product getIdBestNew();

}
