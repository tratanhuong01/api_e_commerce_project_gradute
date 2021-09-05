package com.api.api_e_commerce_project_gradute.ram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends JpaRepository<Ram,String> {

  @Query(value = "SELECT * FROM ram WHERE id = ?1 ",nativeQuery = true)
  Ram getRamByIdRam(Long id);

}
