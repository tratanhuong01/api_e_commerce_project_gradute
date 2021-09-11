package com.api.api_e_commerce_project_gradute.discount_code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode,Long> {

  @Query(value = "SELECT dc.* FROM discount_code dc INNER JOIN discount_code_user dcu " +
      "ON dc.id = dcu.id_discount_code WHERE dc.code = ?1  ",nativeQuery = true)
  DiscountCode checkDiscountCodeIsValid(String code);

  @Query(value = "SELECT dc.* FROM discount_code dc INNER JOIN discount_code_user dcu " +
      "ON dc.id = dcu.id_discount_code WHERE dc.code = ?1 and dcu.id_user = ?2 ",nativeQuery = true)
  DiscountCode checkUserIsUsed(String code,String idUser);

  @Query(value = "SELECT dc.* FROM discount_code dc INNER JOIN discount_code_user dcu " +
      "ON dc.id = dcu.id_discount_code WHERE dc.code = ?1 and NOW() <= dc.time_expired ",nativeQuery = true)
  DiscountCode checkDiscountCodeStillExpired(String code);

}
