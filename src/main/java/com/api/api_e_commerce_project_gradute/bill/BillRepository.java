package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 AND status = ?2 ORDER BY time_created DESC ",nativeQuery = true)
  List<Bill> getBillByIdUserAndTypeAll(String idUSer,int type);

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 ORDER BY time_created DESC ",nativeQuery = true)
  List<Bill> getBillByIdUserAll(String idUSer);

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 AND status = ?2  ORDER BY time_created DESC " +
      " LIMIT ?3 , ?4 ",nativeQuery = true)
  List<Bill> getBillByIdUserAndTypeLimit(String idUSer,int type,int offset, int limit);

  @Transactional
  @Modifying
  @Query(value = "UPDATE bill SET status = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateStatusBill(int status,Long idBill);

  @Query(value = "SELECT * FROM bill WHERE id_user = ?1 ORDER BY time_created DESC " +
      " LIMIT ?2 , ?3 ",nativeQuery = true)
  List<Bill> getBillByIdUserLimit(String idUSer,int offset, int limit);

  @Query(value = "SELECT * FROM bill WHERE id = ?1 ",nativeQuery = true)
  Bill getBillById(Long id);

  @Query(value = "SELECT b.* FROM bill b INNER JOIN bill_detail bd ON b.id = bd.id_bill " +
      "INNER JOIN product p ON bd.id_product = p.id INNER JOIN line_product lp ON " +
      "p.id_line_product = lp.id WHERE (lp.name_line_product LIKE %:keyword:% OR " +
      "b.id = %:keyword:% ) AND b.id_user = :idUser ORDER BY b.time_created DESC LIMIT :offset , :limit ",nativeQuery = true)
  List<Bill> searchBill(@Param("keyword") String keyword, @Param("idUser") String idUser,
                        @Param("offset")  int offset, @Param("limit") int limit);

}
