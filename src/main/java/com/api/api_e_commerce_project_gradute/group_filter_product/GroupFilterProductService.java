package com.api.api_e_commerce_project_gradute.group_filter_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    groupFilterProductRepository.save(groupFilterProduct);
    return groupFilterProductRepository.findAll();
  }

}
