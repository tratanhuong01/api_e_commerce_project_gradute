package com.api.api_e_commerce_project_gradute.group_filter_product;

import com.api.api_e_commerce_project_gradute.attribute.Attribute;
import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_filter_product")
public class GroupFilterProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_group_product")
  private GroupProduct groupProductFilter;

  @Column
  private String nameGroupFilterProduct;

  @Column
  private int typeGroupFilterProduct;

  @Column
  private Timestamp timeCreated;

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
