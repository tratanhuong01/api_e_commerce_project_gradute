package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BillController {

  @Autowired
  BillService billService;

  @CrossOrigin
  @GetMapping("billsAll")
  public List<Bill> getBillByIdAll(@RequestParam(required = false) int type,@RequestParam(required = false) String idUser) {
    return billService.getAllBills(idUser,type);
  }

  @CrossOrigin
  @GetMapping("bills")
  public List<BillFull> getBillById(@RequestParam(required = false) int type, @RequestParam(required = false) String idUser,
                                    @RequestParam(required = false) int offset, @RequestParam(required = false) int limit) {
    return billService.getBillByUser(idUser,type,offset,limit);
  }

  @CrossOrigin
  @GetMapping("bills/{id}")
  public BillFull getBillById(@PathVariable Long id) {
    return billService.getBillById(id);
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

  @CrossOrigin
  @GetMapping("bills/update/status/")
  public int cancelOrder(@RequestParam(required = false) Long idBill,@RequestParam(required = false) int status) {
    return billService.updateStatusBill(idBill,status);
  }

  @CrossOrigin
  @GetMapping("bills/search/")
  public List<BillFull> searchBill(@RequestParam(required = false) String keyword,@RequestParam String idUser,
                                   @RequestParam(required = false) int offset , @RequestParam int limit,
                                   @RequestParam(required = false) int type) {
    return billService.searchBill(keyword,idUser,offset,limit,type);
  }

}
