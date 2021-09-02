package com.api.api_e_commerce_project_gradute.image_other;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageOtherRepository extends JpaRepository<ImageOther,Long> {

  @Query(value = "SELECT * FROM image_other WHERE id_line_product = ?1 ",nativeQuery = true)
  List<ImageOther> getImageOtherByIdLineProduct(String idLineProduct);

}
