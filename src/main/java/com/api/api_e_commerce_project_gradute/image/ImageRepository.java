package com.api.api_e_commerce_project_gradute.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

  @Query(value = "SELECT * FROM image WHERE id = ?1 ",nativeQuery = true)
  Image getImageByIdImage(Long idImage);

  @Query(value = "SELECT * FROM image WHERE id_line_product = ?1 ",nativeQuery = true)
  List<Image> getImageByIdLineProduct(String idLineProduct);

  @Query(value = "SELECT image.* FROM image WHERE id_line_product = ?1 AND id_color = ?2 ",nativeQuery = true)
  Image getImageByIdLineProductAndColor(String idLineProduct,Long idColor);

  @Query(value = "SELECT * FROM image WHERE image.id IN (SELECT product.id_image FROM product " +
          "INNER JOIN image ON product.id_image = image.id WHERE product.id_line_product = ?1 " +
          "GROUP BY product.id_image) ",nativeQuery = true)
  List<Image> getImageLineProduct(String idLineProduct);

}
