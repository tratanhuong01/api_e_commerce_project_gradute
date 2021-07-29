package com.api.api_e_commerce_project_gradute.product_output;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOutputRepository extends JpaRepository<ProductOutput,Long> {
}
