package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,String> {

  @Query(value = "SELECT * FROM brand WHERE id = ?1 ",nativeQuery = true)
  Brand getBrandByIdBrand(String idBrand);

}
