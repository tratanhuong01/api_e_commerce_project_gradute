package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {

  //admin

  Page<Bill> findAll(@Nullable Specification<Bill> billSpecification, Pageable pageable);

  List<Bill> findAll(@Nullable Specification<Bill> billSpecification);

  @Query(value = "SELECT * FROM bill WHERE status = ?1 ORDER BY time_created DESC ",nativeQuery = true)
  List<Bill> getBillAllByStatus(int status);

  @Query(value = "SELECT * FROM bill ORDER BY time_created DESC ",nativeQuery = true)
  List<Bill> getBillAll();

  @Query(value = "SELECT * FROM bill WHERE status = ?1 ORDER BY time_created DESC LIMIT ?2 , ?3 ",nativeQuery = true)
  List<Bill> getBillAllByStatusLimit(int status,int offset, int limit);

  @Query(value = "SELECT * FROM bill ORDER BY time_created DESC  LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Bill> getBillAllLimit(int offset,int limit);

  @Query(value = "SELECT COUNT(*) FROM bill WHERE bill.time_created >=  CONCAT(DATE(NOW()),' 00:00:00' )",nativeQuery = true)
  Integer getBillToday();

  @Query(value = "SELECT SUM(bill_detail.amount) FROM bill INNER JOIN bill_detail ON bill.id = \n" +
      "bill_detail.id_bill WHERE bill.time_created >= CONCAT(DATE(NOW()),' 00:00:00' ) AND (" +
      " bill.status != -1 OR bill.status != -2 OR bill.status != 4 ) ",nativeQuery = true)
  Integer getProductSellToday();

  @Query(value = "SELECT SUM(bill.total) FROM bill WHERE bill.time_created >= CONCAT(DATE(NOW()),' 00:00:00' ) " +
      "AND (bill.status != -1 OR bill.status != -2 OR bill.status != 4 ) ",nativeQuery = true)
  Integer getTotalMoneyBillToday();

  @Query(value = "SELECT SUM(detail_bill.price*bill_detail.amount) FROM bill INNER JOIN bill_detail ON bill.id = " +
      "bill_detail.id_bill INNER JOIN product ON product.id = bill_detail.id_product INNER JOIN info_product ON product.id = " +
      "info_product.id_product WHERE bill.time_created >= CONCAT(DATE(NOW()),' 00:00:00' ) AND " +
      "bill.status != -1 OR bill.status != -2 OR bill.status != 4 ",nativeQuery = true)
  Integer getSumDetailBillTotalProfitToday();

  //user

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

  @Query(value = "SELECT * FROM bill ORDER BY time_created DESC " +
      " LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Bill> getBillByIdUserLimitAdmin(int offset, int limit);

  @Query(value = "SELECT * FROM bill WHERE id = ?1 ",nativeQuery = true)
  Bill getBillById(Long id);

  @Query(value = "SELECT b.* FROM bill b INNER JOIN bill_detail bd ON b.id = bd.id_bill " +
      "INNER JOIN product p ON bd.id_product = p.id INNER JOIN line_product lp ON " +
      "p.id_line_product = lp.id WHERE (lp.name_line_product LIKE CONCAT('%',:keyword,'%') OR " +
      "b.id = :keyword ) AND b.id_user = :idUser ORDER BY b.time_created DESC LIMIT :offset , :limit ",nativeQuery = true)
  List<Bill> searchBillLimit(@Param("keyword") String keyword, @Param("idUser") String idUser,
                        @Param("offset")  int offset, @Param("limit") int limit);

  @Query(value = "SELECT b.* FROM bill b INNER JOIN bill_detail bd ON b.id = bd.id_bill " +
      "INNER JOIN product p ON bd.id_product = p.id INNER JOIN line_product lp ON " +
      "p.id_line_product = lp.id WHERE (lp.name_line_product LIKE CONCAT('%',:keyword,'%') OR " +
      "b.id = :keyword ) AND b.id_user = :idUser ORDER BY b.time_created DESC  ",nativeQuery = true)
  List<Bill> searchBill(@Param("keyword") String keyword, @Param("idUser") String idUser);

  @Query(value = "SELECT COUNT(*) " +
      "FROM bill " +
      "WHERE MONTH(time_created) = MONTH(CURRENT_DATE()) - ?1 " +
      "AND YEAR(time_created) = YEAR(CURRENT_DATE()) " +
      "AND time_created <= CONCAT(YEAR(CURRENT_DATE()),'-',MONTH(CURRENT_DATE()),'-','01',' ','00:00:00')",
        nativeQuery = true)
  Integer getBillSixMonthCurrent(Integer value);

  @Query(value = "SELECT SUM(bill_detail.amount) FROM bill INNER JOIN bill_detail ON bill.id = bill_detail.id_bill " +
      " WHERE MONTH(time_created) = MONTH(CURRENT_DATE()) - ?1 " +
      " AND YEAR(time_created) = YEAR(CURRENT_DATE()) " +
      " AND time_created <= CONCAT(YEAR(CURRENT_DATE()),'-',MONTH(CURRENT_DATE()),'-','01',' ','00:00:00')" +
      " AND (bill.status != -1 OR bill.status != -2 OR bill.status != 4 ) ",nativeQuery = true)
  Integer getProductSixMonthCurrent(Integer value);

}
