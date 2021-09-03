package com.api.api_e_commerce_project_gradute.attribute_product;

import com.api.api_e_commerce_project_gradute.DTO.AttributeByGroupAttribute;
import com.api.api_e_commerce_project_gradute.group_attribute.GroupAttribute;
import com.api.api_e_commerce_project_gradute.group_attribute.GroupAttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeProductService {

  @Autowired
  AttributeProductRepository attributeProductRepository;

  @Autowired
  GroupAttributesRepository groupAttributesRepository;

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

  public List<AttributeByGroupAttribute> getAttributeProductByIdLineProduct(String idLineProduct) {
    List<AttributeByGroupAttribute> attributeByGroupAttributeList = new ArrayList<>();
    List<String> stringList = attributeProductRepository.getDistinctGroupAttributeByIdLineProduct(idLineProduct);
    for (String string: stringList) {
      AttributeByGroupAttribute attributeByGroupAttribute = new AttributeByGroupAttribute();
      attributeByGroupAttribute.setGroupAttribute(groupAttributesRepository.getGroupAttributeById(string));
      attributeByGroupAttribute.setAttributeProductList(attributeProductRepository.getAttributeProductByIdLineProductAndGroupAttribute(
          idLineProduct,string
      ));
      attributeByGroupAttributeList.add(attributeByGroupAttribute);
    }
    return attributeByGroupAttributeList;
  }

}
