package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LineProductService {

  @Autowired
  LineProductRepository lineProductRepository;

  public List<LineProduct> getAllLineProducts() {
    return lineProductRepository.findAll();
  }

  public Optional<LineProduct> getLineProductById(String idLineProduct) {
    return lineProductRepository.findById(idLineProduct);
  }

  public LineProduct addLineProduct(LineProduct lineProduct) {
    LineProduct lineProductGet = lineProductRepository.getIdBestNew();
    if (lineProductGet == null)
      lineProduct.setId("LP1000000000");
    else {
      int id = Integer.parseInt(lineProductGet.getId().split("LP")[1]);
      id++;
      lineProduct.setId(String.valueOf("LP"+id));
    }
    lineProduct.setTimeCreated(new Timestamp(new Date().getTime()));
    return lineProductRepository.save(lineProduct);
  }

  public LineProduct updateLineProduct(LineProduct lineProduct) {
    return lineProductRepository.save(lineProduct);
  }

  public List<LineProduct> getAllLineProductLimit(int offset,int limit) {
    return lineProductRepository.getAllLineProductLimit(offset, limit);
  }

  public List<LineProduct> getLineProductByIdGroupProduct(String idGroupProduct) {
    return lineProductRepository.getLineProductByIdGroupProduct(idGroupProduct);
  }

  public List<LineProduct> searchLineProductAll(String keyword) {
    return lineProductRepository.searchLineProductAll(keyword);
  }

  public List<LineProduct> searchLineProductLimit(String keyword, int offset, int limit) {
    return lineProductRepository.searchLineProductLimit(keyword,offset,limit);
  }

  public void deleteLineProduct(LineProduct LineProduct) {
    lineProductRepository.delete(LineProduct);
  }

}
