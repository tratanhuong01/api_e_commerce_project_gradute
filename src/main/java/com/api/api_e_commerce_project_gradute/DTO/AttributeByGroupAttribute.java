package com.api.api_e_commerce_project_gradute.DTO;

import com.api.api_e_commerce_project_gradute.attribute_product.AttributeProduct;
import com.api.api_e_commerce_project_gradute.group_attribute.GroupAttribute;

import java.util.List;

public class AttributeByGroupAttribute {

  private GroupAttribute groupAttribute;
  private List<AttributeProduct> attributeProductList;

  public GroupAttribute getGroupAttribute() {
    return groupAttribute;
  }

  public void setGroupAttribute(GroupAttribute groupAttribute) {
    this.groupAttribute = groupAttribute;
  }

  public List<AttributeProduct> getAttributeProductList() {
    return attributeProductList;
  }

  public void setAttributeProductList(List<AttributeProduct> attributeProductList) {
    this.attributeProductList = attributeProductList;
  }
}
