package com.api.api_e_commerce_project_gradute.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

  @Query(value = "SELECT * FROM user ORDER BY id DESC LIMIT 1",nativeQuery = true)
  User getIdBestNew();

  @Query(value = "SELECT * FROM user WHERE email = ?1  ",nativeQuery = true)
  List<User> getUserByEmail(String email);

  @Query(value = "SELECT * FROM user WHERE phone = ?1  ",nativeQuery = true)
  List<User> getUserByPhone(String phone);

  @Query(value = "SELECT * FROM user WHERE (email = ?1 or phone = ?2) AMD password = ?3 ",nativeQuery = true)
  User checkLogin(String emailOrPhone,String password);

  @Transactional
  @Modifying
  @Query(value = "UPDATE user SET code_email = ?1 WHERE id_user = ?2 ")
  String updateCodeEmail(String codeEmail,String idUser);

}
