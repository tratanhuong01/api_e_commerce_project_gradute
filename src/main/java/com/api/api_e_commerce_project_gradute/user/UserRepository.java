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

  @Query(value = "SELECT * FROM user WHERE ( email = ?1 or phone = ?1 ) AND password = ?2 ",nativeQuery = true)
  User checkLogin(String emailOrPhone,String password);

  @Transactional
  @Modifying
  @Query(value = "UPDATE user SET code_email = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateCodeEmail(String codeEmail,String idUser);

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

  @Query(value = "SELECT * FROM user WHERE type = 2 ",nativeQuery = true)
  List<User> getTeleSupport();

  @Query(value = "SELECT * FROM user WHERE type = ?1 ORDER BY time_created DESC LIMIT ?2 , ?3 ",nativeQuery = true)
  List<User> getUserByTypeLimit(int type,int offset,int limit);

  @Query(value = "SELECT COUNT(*) FROM user WHERE user.time_created > CONCAT(DATE(NOW()),' 00:00:00' ) ",nativeQuery = true)
  int getUserRegisterToDay();

}
