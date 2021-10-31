package com.api.api_e_commerce_project_gradute.discount_code_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DiscountCodeUserRepository extends JpaRepository<DiscountCodeUser,Long> {

  @Query(value = "SELECT dcu.* FROM discount_code_user dcu INNER JOIN discount_code dc " +
      "ON dcu.id_discount_code = dc.id WHERE dcu.id_user = ?1 AND dcu.is_used = ?2 AND " +
      "NOW() < dc.time_expired ORDER BY dc.time_expired DESC ",nativeQuery = true)
  List<DiscountCodeUser> getDiscountCodeUserByIdUser(String idUser,int isUsed);

  @Query(value = "SELECT dcu.* FROM discount_code_user dcu INNER JOIN discount_code dc " +
          "ON dcu.id_discount_code = dc.id WHERE dcu.id_user = ?1 AND dcu.is_used = ?2  ",nativeQuery = true)
  List<DiscountCodeUser> getDiscountCodeUserByIdUserUsed(String idUser,int isUsed);

  @Query(value = "SELECT dcu.* FROM discount_code_user dcu INNER JOIN discount_code dc " +
      "ON dcu.id_discount_code = dc.id WHERE dcu.id_user = ?1 AND dcu.is_used = ?2 AND " +
      "NOW() < dc.time_expired AND dc.time_expired < DATE_ADD(NOW(), INTERVAL 2 DAY) ",nativeQuery = true)
  List<DiscountCodeUser> getDiscountCodeUserNearExpired(String idUser,int isUsed);

  @Query(value = "SELECT dcu.* FROM discount_code_user dcu INNER JOIN discount_code dc " +
      "ON dcu.id_discount_code = dc.id WHERE NOW() > dc.time_expired AND dcu.is_used = 0 " +
      "AND dcu.id_user = ? ",nativeQuery = true)
  List<DiscountCodeUser> getDiscountCodeUserExpired(String idUser);

  @Query(value = "SELECT * FROM discount_code_user WHERE id_discount_code = ?1 AND id_user = ?2 ",nativeQuery = true)
  DiscountCodeUser checkDiscountCodeUserHave(Long idDiscountCode,String idUser);

  @Query(value = "SELECT * FROM discount_code_user INNER JOIN discount_code ON discount_code_user.id_discount_code = " +
          "discount_code.id WHERE discount_code.code = ?1 AND discount_code_user.id_user = ?2 AND " +
          "(discount_code_user.is_used = 0 OR discount_code_user.is_used = 1) AND NOW() < discount_code.time_expired",nativeQuery = true)
  DiscountCodeUser checkDiscountCodeUserValidAdd(String code,String idUser);

  @Transactional
  @Modifying
  @Query(value = "UPDATE discount_code_user SET is_used = ?1 WHERE id_discount_code = ?2 AND " +
      "id_user = ?3 ",nativeQuery = true)
  int updateDiscountCodeUserIsUsed(int isUsed,Long idDiscountCode,String idUser);

}
