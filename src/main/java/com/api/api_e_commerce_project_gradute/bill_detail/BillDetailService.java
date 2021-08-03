package com.api.api_e_commerce_project_gradute.bill_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService {

  @Autowired
  BillDetailRepository billDetailRepository;

  public List<BillDetail> getAllBillDetails() {
    return billDetailRepository.findAll();
  }

  public BillDetail getBillDetailById(Long idBillDetail) {
    return billDetailRepository.getById(idBillDetail);
  }

  public BillDetail addBillDetail(BillDetail billDetail) {
    return billDetailRepository.save(billDetail);
  }

}
