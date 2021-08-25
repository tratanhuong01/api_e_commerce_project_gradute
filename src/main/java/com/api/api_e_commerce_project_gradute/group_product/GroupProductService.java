package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupProductService {

  @Autowired
  GroupProductRepository groupProductRepository;

  public List<GroupProduct> getAllGroupProducts() {
    return groupProductRepository.findAll();
  }

  public Optional<GroupProduct> getGroupProductById(String idGroupProduct) {
    return groupProductRepository.findById(idGroupProduct);
  }

  public GroupProduct addGroupProduct(GroupProduct groupProduct) {
    return groupProductRepository.save(groupProduct);
  }

  public List<GroupProduct> getGroupProductLimit(int offset,int limit) {
    return groupProductRepository.getAllGroupProductLimit(offset, limit);
  }

}
