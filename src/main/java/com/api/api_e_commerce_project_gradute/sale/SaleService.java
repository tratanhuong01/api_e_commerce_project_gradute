package com.api.api_e_commerce_project_gradute.sale;

import com.api.api_e_commerce_project_gradute.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

  @Autowired
  SaleRepository saleRepository;

  @Autowired
  ProductRepository productRepository;

  public List<Sale> getAllSales() {
    return saleRepository.findAll();
  }

  public Optional<Sale> getSaleById(Long idSale) {
    return saleRepository.findById(idSale);
  }

  public Sale addSale(Sale sale,String id) {
    sale.setProductSale(productRepository.getProductById(id));
    return saleRepository.save(sale);
  }

}