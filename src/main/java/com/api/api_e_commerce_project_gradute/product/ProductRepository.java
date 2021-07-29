package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
