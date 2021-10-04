package com.api.api_e_commerce_project_gradute.discount_code;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.util.List;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode,Long> {

  List<DiscountCode> findAll(@Nullable Specification<DiscountCode> discountCodeSpecification);

  Page<DiscountCode> findAll(@Nullable Specification<DiscountCode> discountCodeSpecification, Pageable pageable);

  @Query(value = "SELECT dc.* FROM discount_code dc  WHERE dc.code = ?1  ",nativeQuery = true)
  DiscountCode checkDiscountCodeIsValid(String code);

  @Query(value = "SELECT dc.* FROM discount_code dc LEFT JOIN discount_code_user dcu " +
      "ON dc.id = dcu.id_discount_code WHERE dc.code = ?1 and dcu.id_user = ?2 AND dcu.is_used = ?3 ",nativeQuery = true)
  DiscountCode checkUserIsUsed(String code,String idUser,int isUsed);

  @Query(value = "SELECT dc.* FROM discount_code dc LEFT JOIN discount_code_user dcu " +
      "ON dc.id = dcu.id_discount_code WHERE dc.code = ?1 and NOW() <= dc.time_expired ",nativeQuery = true)
  DiscountCode checkDiscountCodeStillExpired(String code);

}
