package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
    groupProduct.setTimeCreated(new Timestamp(new Date().getTime()));
    return groupProductRepository.save(groupProduct);
  }

  public GroupProduct updateGroupProduct(GroupProduct groupProduct) {
    return groupProductRepository.save(groupProduct);
  }

  public List<GroupProduct> getGroupProductLimit(int offset,int limit) {
    return groupProductRepository.getAllGroupProductLimit(offset, limit);
  }

  public List<GroupProduct> getGroupProductByIdCategoryProduct(String idCategory) {
    return groupProductRepository.getGroupProductByIdCategoryProduct(idCategory);
  }

  public List<GroupProduct> getGroupProductBySlugCategoryProduct(String slugCategory) {
    return groupProductRepository.getGroupProductBySlugCategoryProduct(slugCategory);
  }

  public List<GroupProduct> searchGroupProductAll(String keyword) {
    return groupProductRepository.searchGroupProductAll(keyword);
  }

  public List<GroupProduct> searchGroupProductLimit(String keyword, int offset, int limit) {
    return groupProductRepository.searchGroupProductLimit(keyword,offset,limit);
  }

  public void deleteGroupProduct(GroupProduct groupProduct) {
    groupProductRepository.delete(groupProduct);
  }

}
