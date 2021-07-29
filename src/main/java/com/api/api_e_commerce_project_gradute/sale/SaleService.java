package com.api.api_e_commerce_project_gradute.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

  @Autowired
  SaleRepository saleRepository;

  public List<Sale> getAllSales() {
    return saleRepository.findAll();
  }

  public Sale getSaleById(Long idSale) {
    return saleRepository.getById(idSale);
  }

  public Sale addSale(Sale sale) {
    return saleRepository.save(sale);
  }

}
