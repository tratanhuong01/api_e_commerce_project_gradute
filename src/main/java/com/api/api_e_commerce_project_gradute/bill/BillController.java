package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.DashboardHeader;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class BillController {

  @Autowired
  BillService billService;

  @GetMapping("billsAll")
  public List<Bill> getBillByIdAll(@RequestParam(required = false) int type,@RequestParam(required = false) String idUser) {
    return billService.getAllBills(idUser,type);
  }

  @GetMapping("billsAll/admin/")
  public List<Bill> getBillByIdAllAdmin() {
    return billService.getAllBillAdminAll();
  }

  @GetMapping("bills/admin/")
  public List<Bill> getAllBillAdminAllLimit(@RequestParam(required = false) int offset,@RequestParam(required = false) int limit) {
    return billService.getAllBillAdminAllLimit(offset, limit);
  }

  @GetMapping("bills")
  public List<BillFull> getBillById(@RequestParam(required = false) int type, @RequestParam(required = false) String idUser,
                                    @RequestParam(required = false) int offset, @RequestParam(required = false) int limit) {
    return billService.getBillByUser(idUser,type,offset,limit);
  }

  @GetMapping("bills/{id}")
  public BillFull getBillById(@PathVariable Long id) {
    return billService.getBillById(id);
  }

  @PostMapping("bills")
  public Bill addBill(@RequestBody Bill bill) {
    return billService.addBill(bill);
  }

  @PutMapping("bills")
  public Bill updateBill(@RequestBody Bill bill) {
    return billService.addBill(bill);
  }

  @GetMapping("bills/update/status/")
  public int cancelOrder(@RequestParam(required = false) Long idBill,@RequestParam(required = false) int status) {
    return billService.updateStatusBill(idBill,status);
  }

  @GetMapping("bills/search/")
  public List<BillFull> searchBill(@RequestParam(required = false) String keyword,@RequestParam String idUser,
                                   @RequestParam(required = false) int offset , @RequestParam int limit,
                                   @RequestParam(required = false) int type) {
    return billService.searchBill(keyword,idUser,offset,limit,type);
  }

  @GetMapping("getDashboardHeader")
  public DashboardHeader getDashboardHeader() {
    return billService.getDashboardHeader();
  }

}
