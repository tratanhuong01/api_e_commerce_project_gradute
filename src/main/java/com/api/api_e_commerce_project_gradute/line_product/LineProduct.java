package com.api.api_e_commerce_project_gradute.line_product;

import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product_input.ProductInput;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "line_product")
public class LineProduct {

  @Id
  private String id;

  @OneToMany(mappedBy = "lineProduct")
  private Set<Product> lineProduct = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "id_group_product")
  private GroupProduct groupProduct;

  @Column
  private String nameLineProduct;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GroupProduct getGroupProduct() {
    return groupProduct;
  }

  public void setGroupProduct(GroupProduct groupProduct) {
    this.groupProduct = groupProduct;
  }

  public String getNameLineProduct() {
    return nameLineProduct;
  }

  public void setNameLineProduct(String nameLineProduct) {
    this.nameLineProduct = nameLineProduct;
  }
}
