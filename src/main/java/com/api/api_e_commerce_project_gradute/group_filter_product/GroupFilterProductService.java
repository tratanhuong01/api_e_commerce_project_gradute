package com.api.api_e_commerce_project_gradute.group_filter_product;

import com.api.api_e_commerce_project_gradute.function_product.FunctionProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class GroupFilterProductService {

  @Autowired
  GroupFilterProductRepository groupFilterProductRepository;

  public List<GroupFilterProduct> getAllGroupFilterProducts() {
    return groupFilterProductRepository.findAll();
  }

  public List<GroupFilterProduct> getAllGroupFilterProductLimit(int offset, int limit) {
    return groupFilterProductRepository.getAllGroupFilterProductLimit(offset, limit);
  }

  public List<GroupFilterProduct> addGroupFilterProduct(GroupFilterProduct groupFilterProduct) {
    groupFilterProduct.setTimeCreated(new Timestamp(new Date().getTime()));
    groupFilterProductRepository.save(groupFilterProduct);
    return groupFilterProductRepository.findAll();
  }

  public List<GroupFilterProduct> updateGroupFilterProduct(GroupFilterProduct groupFilterProduct) {
    groupFilterProductRepository.save(groupFilterProduct);
    return groupFilterProductRepository.findAll();
  }

  public List<GroupFilterProduct> searchGroupFilterProductAll(String keyword) {
    return groupFilterProductRepository.searchGroupFilterProductAll(keyword);
  }

  public List<GroupFilterProduct> searchGroupFilterProductLimit(String keyword,int offset,int limit) {
    return groupFilterProductRepository.searchGroupFilterProductLimit(keyword,offset,limit);
  }

  public void deleteGroupFilterProduct(GroupFilterProduct groupFilterProduct) {
    groupFilterProductRepository.delete(groupFilterProduct);
  }

}
