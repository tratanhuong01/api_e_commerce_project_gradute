package com.api.api_e_commerce_project_gradute.attribute_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeProductService {

  @Autowired
  AttributeProductRepository attributeProductRepository;

  public List<AttributeProduct> getAllAttributeProduct() {
    return attributeProductRepository.findAll();
  }

  public List<AttributeProduct> getAllAttributeProductLimit(int offset,int limit) {
    return attributeProductRepository.getAllAttributeProductLimit(offset, limit);
  }

  public List<AttributeProduct> addAttributeProduct(AttributeProduct attributeProduct) {
    attributeProductRepository.save(attributeProduct);
    return attributeProductRepository.findAll();
  }

}
