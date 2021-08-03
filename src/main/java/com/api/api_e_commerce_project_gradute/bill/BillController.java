package com.api.api_e_commerce_project_gradute.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {

  @Autowired
  BillService billService;

  @CrossOrigin
  @GetMapping("bills")
  public List<Bill> getAllBills() {
    return billService.getAllBills();
  }

  @CrossOrigin
  @GetMapping("bills/{idBill}")
  public Bill getBillById(@PathVariable String idBill) {
    return billService.getBillById(idBill);
  }

  @CrossOrigin
  @PostMapping("bills")
  public Bill addBill(@RequestBody Bill bill) {
    return billService.addBill(bill);
  }

  @CrossOrigin
  @PutMapping("bills")
  public Bill updateBill(@RequestBody Bill bill) {
    return billService.addBill(bill);
  }

}
