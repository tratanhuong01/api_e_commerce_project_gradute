package com.api.api_e_commerce_project_gradute.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,String> {

  @Query(value = "SELECT * FROM color WHERE id = ?1 ",nativeQuery = true)
  Color getColorByIdColor(String idColor);

}