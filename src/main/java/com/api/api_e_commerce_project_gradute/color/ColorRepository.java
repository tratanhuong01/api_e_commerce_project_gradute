package com.api.api_e_commerce_project_gradute.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<Color,String> {

  @Query(value = "SELECT * FROM color WHERE id = ?1 ",nativeQuery = true)
  Color getColorByIdColor(Long idColor);

  @Query(value = "SELECT * FROM color ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Color> getColorsLimit(int offset,int limit);

  @Query(value = "SELECT * FROM color WHERE id = :keyword OR code LIKE CONCAT('%',:keyword,'%') OR description " +
      " LIKE CONCAT('%',:keyword,'%') LIMIT :offset , :limit ",nativeQuery = true)
  List<Color> searchColorLimit(@Param("keyword") String keyword, @Param("offset") int offset,
                               @Param("limit") int limit);

  @Query(value = "SELECT * FROM color WHERE id = :keyword OR code LIKE CONCAT('%',:keyword,'%') " +
      " OR description LIKE CONCAT('%',:keyword,'%') ",
      nativeQuery = true)
  List<Color> searchColorAll(@Param("keyword") String keyword);

  @Query(value = "SELECT color.* FROM color INNER JOIN image ON color.id = image.id_color INNER JOIN product " +
      "ON product.id_image = image.id WHERE product.id_line_product = ?1 ",nativeQuery = true)
  List<Color> getListColorByLineProduct(String idLineProduct);

}
