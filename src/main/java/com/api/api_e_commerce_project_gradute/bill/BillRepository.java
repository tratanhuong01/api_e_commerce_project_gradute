package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 AND status = ?2 ",nativeQuery = true)
  List<Bill> getBillByIdUserAndTypeAll(String idUSer,int type);

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 AND status = ?2 LIMIT ?3 , ?4 ",nativeQuery = true)
  List<Bill> getBillByIdUserAndTypeLimit(String idUSer,int type,int offset, int limit);

}
