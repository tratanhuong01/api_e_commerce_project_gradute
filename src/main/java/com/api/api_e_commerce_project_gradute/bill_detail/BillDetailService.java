package com.api.api_e_commerce_project_gradute.bill_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillDetailService {

  @Autowired
  BillDetailRepository billDetailRepository;

  public List<BillDetail> getAllBillDetails() {
    return billDetailRepository.findAll();
  }

  public Optional<BillDetail> getBillDetailById(Long idBillDetail) {
    return billDetailRepository.findById(idBillDetail);
  }

  public BillDetail addBillDetail(BillDetail billDetail) {
    return billDetailRepository.save(billDetail);
  }

}
