package com.api.api_e_commerce_project_gradute.sale;

import com.api.api_e_commerce_project_gradute.DTO.sale.SaleAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SaleController {

  @Autowired
  SaleService saleService;

  @CrossOrigin
  @GetMapping("sales")
  public List<Sale> getAllSales() {
    return saleService.getAllSales();
  }

  @CrossOrigin
  @GetMapping("sales/{idSale}")
  public Optional<Sale> getSaleById(@PathVariable Long idSale) {
    return saleService.getSaleById(idSale);
  }

  @CrossOrigin
  @PostMapping("sales")
  public Sale addSale(@RequestBody SaleAdd saleAdd) {
    return saleService.addSale(saleAdd.getSale(),saleAdd.getId());
  }

  @CrossOrigin
  @PostMapping("sale")
  public Sale updateSale(@RequestBody Sale sale) {
    return saleService.addSale(sale,"");
  }

}
