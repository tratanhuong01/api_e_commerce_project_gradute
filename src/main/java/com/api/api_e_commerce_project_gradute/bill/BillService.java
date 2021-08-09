package com.api.api_e_commerce_project_gradute.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

  @Autowired
  BillRepository billRepository;

  public List<Bill> getAllBills() {
    return billRepository.findAll();
  }

  public Optional<Bill> getBillById(String idBill) {
    return billRepository.findById(idBill);
  }

  public Bill addBill(Bill bill) {
    return billRepository.save(bill);
  }

}
