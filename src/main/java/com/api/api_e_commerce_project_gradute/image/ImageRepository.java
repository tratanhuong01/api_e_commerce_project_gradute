package com.api.api_e_commerce_project_gradute.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

  @Query(value = "SELECT * FROM image WHERE id = ?1 ",nativeQuery = true)
  Image getImageByIdImage(Long idImage);

}
