package com.api.api_e_commerce_project_gradute.line_product;

import com.api.api_e_commerce_project_gradute.brand.Brand;
import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;
import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;
import java.sql.Timestamp;
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

  @ManyToOne
  @JoinColumn(name = "id_brand")
  private Brand brandProduct;

  @Column
  private int height;

  @Column
  private int width;

  @Column
  private int weight;

  @Column
  private Timestamp timeCreated;

  public Brand getBrandProduct() {
    return brandProduct;
  }

  public void setBrandProduct(Brand brandProduct) {
    this.brandProduct = brandProduct;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

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
