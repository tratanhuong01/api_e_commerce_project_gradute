package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 AND status = ?2 ORDER BY time_created DESC ",nativeQuery = true)
  List<Bill> getBillByIdUserAndTypeAll(String idUSer,int type);

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 AND status = ?2  ORDER BY time_created DESC " +
      " LIMIT ?3 , ?4 ",nativeQuery = true)
  List<Bill> getBillByIdUserAndTypeLimit(String idUSer,int type,int offset, int limit);

  @Transactional
  @Modifying
  @Query(value = "UPDATE bill SET status = ?1 WHERE id_bill = ?2 ",nativeQuery = true)
  int updateStatusBill(Long idBill,int status);

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 ORDER BY time_created DESC " +
      " LIMIT ?2 , ?3 ",nativeQuery = true)
  List<Bill> getBillByIdUserLimit(String idUSer,int offset, int limit);

  @Query(value = "SELECT * FROM bill WHERE id = ?1 ",nativeQuery = true)
  Bill getBillById(Long id);

}
