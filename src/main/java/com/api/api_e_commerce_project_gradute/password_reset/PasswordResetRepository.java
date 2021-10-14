package com.api.api_e_commerce_project_gradute.password_reset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset,Long> {

  @Query(value = "SELECT * FROM password_reset WHERE id_user = ?1 AND time_created >= CONCAT(DATE(NOW()),' 00:00:00') ",
      nativeQuery = true)
  List<PasswordReset> getListPasswordReset(String idUser);

}
