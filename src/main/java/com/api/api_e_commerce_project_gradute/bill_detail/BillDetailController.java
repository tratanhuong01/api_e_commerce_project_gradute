package com.api.api_e_commerce_project_gradute.bill_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class BillDetailController {

  @Autowired
  BillDetailService billDetailService;

  @GetMapping("billDetails")
  public List<BillDetail> getAllBillDetails() {
    return billDetailService.getAllBillDetails();
  }

  @GetMapping("billDetails/{idBillDetail}")
  public Optional<BillDetail> getBillDetailById(Long idBillDetail) {
    return billDetailService.getBillDetailById(idBillDetail);
  }

  @PostMapping("billDetails")
  public BillDetail addBillDetail(@RequestBody BillDetail billDetail) {
    return billDetailService.addBillDetail(billDetail);
  }

  @PutMapping("billDetails")
  public BillDetail updateBillDetail(@RequestBody BillDetail billDetail) {
    return billDetailService.addBillDetail(billDetail);
  }

}
