package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;
import com.api.api_e_commerce_project_gradute.sale.Sale;
import com.api.api_e_commerce_project_gradute.product_input.ProductInput;
import com.api.api_e_commerce_project_gradute.product_output.ProductOutput;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
  @Id
  private Long id;

  @OneToMany(mappedBy = "productInput")
  private Set<ProductInput> productInput = new HashSet<>();;

  @OneToMany(mappedBy = "productOutput")
  private Set<ProductOutput> productOutput = new HashSet<>();;

  @OneToMany(mappedBy = "productSale")
  private Set<Sale> productSale = new HashSet<>();;

  @ManyToOne
  @JoinColumn(name = "id_group_product")
  private GroupProduct groupProduct;

  @Column
  private String nameProduct;

  @Column
  private String color;

  @Column
  private String size;

  @Column
  private String image;

  @Column
  private int isShow;

  @Column
  private String describeProduct;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GroupProduct getGroupProduct() {
    return groupProduct;
  }

  public void setGroupProduct(GroupProduct groupProduct) {
    this.groupProduct = groupProduct;
  }

  public String getNameProduct() {
    return nameProduct;
  }

  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getIsShow() {
    return isShow;
  }

  public void setIsShow(int isShow) {
    this.isShow = isShow;
  }

  public String getDescribeProduct() {
    return describeProduct;
  }

  public void setDescribeProduct(String describeProduct) {
    this.describeProduct = describeProduct;
  }
}
