package com.api.api_e_commerce_project_gradute.category_product;

import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category_product")
public class CategoryProduct {

  @Id
  private String id;

  @OneToMany(mappedBy = "categoryGroupProduct")
  private Set<GroupProduct> categoryGroupProduct = new HashSet<>();

  @Column
  private String nameCategoryProduct;

  @Column
  private int type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameCategoryProduct() {
    return nameCategoryProduct;
  }

  public void setNameCategoryProduct(String nameCategoryProduct) {
    this.nameCategoryProduct = nameCategoryProduct;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
