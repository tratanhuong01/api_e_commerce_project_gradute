package com.api.api_e_commerce_project_gradute.group_filter_product;

import com.api.api_e_commerce_project_gradute.attribute.Attribute;
import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;

import javax.persistence.*;

@Entity
@Table(name = "group_filter_product")
public class GroupFilterProduct {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "id_group_product")
  private GroupProduct groupProductFilter;

  @Column
  private String nameGroupFilterProduct;

  @Column
  private int typeGroupFilterProduct;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GroupProduct getGroupProductFilter() {
    return groupProductFilter;
  }

  public void setGroupProductFilter(GroupProduct groupProductFilter) {
    this.groupProductFilter = groupProductFilter;
  }

  public String getNameGroupFilterProduct() {
    return nameGroupFilterProduct;
  }

  public void setNameGroupFilterProduct(String nameGroupFilterProduct) {
    this.nameGroupFilterProduct = nameGroupFilterProduct;
  }

  public int getTypeGroupFilterProduct() {
    return typeGroupFilterProduct;
  }

  public void setTypeGroupFilterProduct(int typeGroupFilterProduct) {
    this.typeGroupFilterProduct = typeGroupFilterProduct;
  }
}
