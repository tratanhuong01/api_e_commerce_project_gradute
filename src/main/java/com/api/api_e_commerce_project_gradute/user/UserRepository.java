package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.discount_code.UserVoucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

  public static String QUERY_GET_USER_REGISTER = "SELECT COUNT(*) FROM user WHERE is_register = 1 AND id_role = 'CUSTOMER' ";

  Page<User> findAll(@Nullable Specification<User> userSpecification, Pageable pageable);

  List<User> findAll(@Nullable Specification<User> userSpecification);

  @Query(value = "SELECT * FROM user WHERE id = ?1 ",nativeQuery = true)
  User getUserByIdUser(String idUser);

  @Query(value = "SELECT * FROM user ORDER BY id DESC LIMIT 1",nativeQuery = true)
  User getIdBestNew();

  @Query(value = "SELECT * FROM user WHERE email = ?1  ",nativeQuery = true)
  List<User> getUserByEmail(String email);

  @Query(value = "SELECT * FROM user WHERE phone = ?1  ",nativeQuery = true)
  List<User> getUserByPhone(String phone);

  @Query(value = "SELECT * FROM user WHERE ( email = ?1 or phone = ?1 ) AND password = ?2 AND is_register = 1 ",nativeQuery = true)
  User checkLogin(String emailOrPhone,String password);

  @Query(value = "SELECT * FROM user WHERE ( email = ?1 or phone = ?1 ) AND password = ?2 AND type != 0 AND id_role != " +
          " 'CUSTOMER' AND is_register = 1 AND status = 0 ",nativeQuery = true)
  User adminCheckLogin(String emailOrPhone,String password);

  @Transactional
  @Modifying
  @Query(value = "UPDATE user SET code_email = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateCodeEmail(String codeEmail,String idUser);

  @Transactional
  @Modifying
  @Query(value = "UPDATE user SET code_phone = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateCodePhone(String codePhone,String idUser);

  @Query(value = "SELECT * FROM user WHERE type = ?1 LIMIT ?2 , ?3 ",nativeQuery = true)
  List<User> getAllUsersLimit(int type,int offset,int limit);

  @Query(value = "SELECT password FROM user WHERE id = ?1 AND password = ?2 ",nativeQuery = true)
  String checkPasswordUser(String idUser,String password);

  @Modifying
  @Transactional
  @Query(value = "UPDATE user SET password = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updatePasswordUser(String password,String idUser);

  @Query(value = "SELECT u.* FROM messages m INNER JOIN user u ON m.id_user = u.id WHERE" +
      " m.id_group_chat = ?1 LIMIT 0,1 ",nativeQuery = true)
  User getAdmin(Long idGroupChat);

  @Query(value = "SELECT * FROM user WHERE id_role = 'SUPPORTER' ",nativeQuery = true)
  List<User> getTeleSupport();

  @Query(value = "SELECT * FROM user WHERE id_role = ?1 AND is_register = 1 ORDER BY time_created DESC LIMIT ?2 , ?3 ",nativeQuery = true)
  List<User> getUserByTypeLimit(String idRole,int offset,int limit);

  @Query(value = "SELECT COUNT(*) FROM user INNER JOIN bill ON bill.id_user = user.id WHERE bill.id_user = ?1 ",nativeQuery = true)
  Integer countBillByUser(String idUser);

  @Query(value = "SELECT SUM(bill_detail.amount) FROM user INNER JOIN bill ON bill.id_user = user.id \n" +
      "INNER JOIN bill_detail ON bill.id = bill_detail.id_bill WHERE bill.id_user = ?1 ",nativeQuery = true)
  Integer countProductBuyByUser(String idUser);

  //update

  @Modifying
  @Transactional
  @Query(value = "UPDATE user SET status = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateStatusUser(Integer status,String id);

  @Query(value = "SELECT COUNT(*) FROM user WHERE is_register = 1 AND id_role = 'CUSTOMER' AND status = 0 ",nativeQuery = true)
  Integer getCustomerRegister();

  @Query(value = "SELECT * FROM user WHERE id_role = ?1 ",nativeQuery = true)
  List<User> getUserByIdRole(String role);

  @Query(value = "SELECT user.id as idUser , SUM(bill_detail.amount) as sumItem FROM user LEFT JOIN bill ON bill.id_user = user.id LEFT JOIN bill_detail " +
          " ON bill_detail.id_bill = bill.id WHERE user.status = 0 AND user.id_role = 'CUSTOMER' AND is_register = 1 " +
          " GROUP BY user.id ORDER BY sumItem DESC LIMIT 0 , ? " ,nativeQuery = true)
  List<UserVoucher> getUserBuyMost(Integer limit);

  @Query(value = "SELECT * FROM user WHERE id_role = 'CUSTOMER' AND (email = :emailOrPhone OR " +
      "phone = :emailOrPhone) LIMIT 0,1 ",nativeQuery = true)
  User searchUserByEmailOrPhone(@Param("emailOrPhone") String emailOrPhone);

  @Query(value = "SELECT * FROM user WHERE email = ?1 LIMIT 0, 1",nativeQuery = true)
  User checkEmailHave(String email);

  @Query(value = "SELECT * FROM user WHERE password = ?1 AND id = ?2 ",nativeQuery = true)
  User checkPassword(String password,String idUser);

  @Modifying
  @Transactional
  @Query(value = "UPDATE user SET phone = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updatePhone(String phone,String idUser);

  @Modifying
  @Transactional
  @Query(value = "UPDATE user SET email = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateEmail(String email,String idUser);

  // filter dashboard
  //Today
  @Query(value = QUERY_GET_USER_REGISTER + " AND user.time_created > CONCAT(DATE(NOW()),' 00:00:00' ) ",nativeQuery = true)
  Integer getUserRegisterToDay();
  //Today
  //Yesterday
  @Query(value = QUERY_GET_USER_REGISTER + " AND user.time_created <= CONCAT(DATE(NOW()),' 00:00:00') AND user.time_created " +
          " >= SUBDATE(CURRENT_DATE, 1) ",nativeQuery = true)
  Integer getUserRegisterYesterday();
  //Yesterday
  //Seven Day
  @Query(value = QUERY_GET_USER_REGISTER + " AND user.time_created <= CONCAT(DATE(NOW()),' 00:00:00') AND user.time_created " +
          " >= SUBDATE(CURRENT_DATE, 7) ",nativeQuery = true)
  Integer getUserRegisterSeven();
  //Seven day

  //Month current
  @Query(value = QUERY_GET_USER_REGISTER + " AND user.time_created <= CONCAT(DATE(NOW()),CONCAT(' ',TIME(NOW()))) " +
          "AND user.time_created  >= CAST(DATE_FORMAT(NOW() ,'%Y-%m-01') as DATE) ",nativeQuery = true)
  Integer getUserRegisterMonthCurrent();
  //Month current

  //Month previous
  @Query(value = QUERY_GET_USER_REGISTER + " AND user.time_created <= CAST(DATE_FORMAT(NOW() ,'%Y-%m-01') as DATE) " +
          "AND user.time_created  >= last_day(CURRENT_DATE - interval 2 month) + interval 1 day ",nativeQuery = true)
  Integer getUserRegisterMonthPrevious();
  //Month previous

  //From to
  @Query(value = QUERY_GET_USER_REGISTER + " AND user.time_created <= CONCAT(?,CONCAT(' ',TIME(NOW()))) " +
          "AND user.time_created  >= ? ",nativeQuery = true)
  Integer getUserRegisterFromTo(String dateTo,String dateFrom);
  //From to

}
