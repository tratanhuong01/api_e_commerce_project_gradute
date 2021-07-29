package com.api.api_e_commerce_project_gradute.repository;

import com.api.api_e_commerce_project_gradute.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
}
