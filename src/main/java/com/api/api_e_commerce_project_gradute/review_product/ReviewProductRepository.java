package com.api.api_e_commerce_project_gradute.review_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewProductRepository extends JpaRepository<ReviewProduct,Long> {
}