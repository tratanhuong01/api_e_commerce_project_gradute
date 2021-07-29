package com.api.api_e_commerce_project_gradute.repository;

import com.api.api_e_commerce_project_gradute.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
