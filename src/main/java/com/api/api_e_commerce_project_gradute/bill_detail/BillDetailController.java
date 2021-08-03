package com.api.api_e_commerce_project_gradute.bill_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillDetailController {

  @Autowired
  BillDetailService billDetailService;

  @CrossOrigin
  @GetMapping("billDetails")
  public List<BillDetail> getAllBillDetails() {
    return billDetailService.getAllBillDetails();
  }

  @CrossOrigin
  @GetMapping("billDetails/{idBillDetail}")
  public BillDetail getBillDetailById(Long idBillDetail) {
    return billDetailService.getBillDetailById(idBillDetail);
  }

  @CrossOrigin
  @PostMapping("billDetails")
  public BillDetail addBillDetail(@RequestBody BillDetail billDetail) {
    return billDetailService.addBillDetail(billDetail);
  }

  @CrossOrigin
  @PutMapping("billDetails")
  public BillDetail updateBillDetail(@RequestBody BillDetail billDetail) {
    return billDetailService.addBillDetail(billDetail);
  }

}
