package com.api.api_e_commerce_project_gradute.product_input;

import com.api.api_e_commerce_project_gradute.product_input.ProductInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInputRepository extends JpaRepository<ProductInput,Long> {
}
