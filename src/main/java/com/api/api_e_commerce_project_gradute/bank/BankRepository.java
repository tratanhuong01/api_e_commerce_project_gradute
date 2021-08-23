package com.api.api_e_commerce_project_gradute.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {

  @Query(value = "SELECT * FROM bank WHERE id_user = ?1 ",nativeQuery = true)
  List<Bank> getBankByIdUser(String id);

}
