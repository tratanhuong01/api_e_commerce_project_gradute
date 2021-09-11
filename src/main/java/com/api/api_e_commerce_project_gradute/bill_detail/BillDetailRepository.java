package com.api.api_e_commerce_project_gradute.bill_detail;

import com.api.api_e_commerce_project_gradute.bill_detail.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Long> {

  @Query(value = "SELECT * FROM bill_detail WHERE id_bill = ?1 ",nativeQuery = true)
  List<BillDetail> getBillDetailByIdBill(Long idBill);

}
