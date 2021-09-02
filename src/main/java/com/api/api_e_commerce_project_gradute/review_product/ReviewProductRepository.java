package com.api.api_e_commerce_project_gradute.review_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewProductRepository extends JpaRepository<ReviewProduct,Long> {

  @Query(value = "SELECT * FROM review_product WHERE id_product = ?1 AND level = ?2 ORDER BY time_created DESC LIMIT ?3 , ?4 ",nativeQuery = true)
  List<ReviewProduct> getAllReviewProductsByIdProductLimit(String idProduct,int level,int offset,int limit);

  @Query(value = "SELECT * FROM review_product WHERE id_product = ?1 AND level = ?2 ",nativeQuery = true)
  List<ReviewProduct> getAllReviewProductsByIdProduct(String idProduct,int level);

  @Query(value = "SELECT COUNT(*) FROM review_product WHERE id_product = ?1 AND star = ?2 ",nativeQuery = true)
  int getSumByIdProductByStar(String idProduct,int star);

  @Query(value = "SELECT COUNT(*) FROM review_product WHERE id_product = ?1 AND image IS NOT NULL ",nativeQuery = true)
  int getReviewHasImageByIdProduct(String idProduct);

  @Query(value = "SELECT * FROM review_product WHERE id_product = ?1 AND star = ?2 ORDER BY time_created DESC " +
      "LIMIT ?3 , ?4 ",nativeQuery = true)
  List<ReviewProduct> getReviewProductByStarByIdProductLimit(String idProduct,int star,int offset,int limit);

  @Query(value = "SELECT * FROM review_product WHERE id_product = ?1 AND star = ?2 ",nativeQuery = true)
  List<ReviewProduct> getReviewProductByStarByIdProductAll(String idProduct,int star);

  @Query(value = "SELECT * FROM review_product WHERE reply = ?1 AND level = 2 ORDER BY time_created LIMIT ?2 , ?3 ",nativeQuery = true)
  List<ReviewProduct> getReviewProductByReply(Long reply,int offset,int limit);

}
