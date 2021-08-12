package com.api.api_e_commerce_project_gradute.group_product;

import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.size.Size;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_product")
public class GroupProduct {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "id_category_product")
  private CategoryProduct categoryGroupProduct;

  @Column
  private String nameGroupProduct;

  @Column
  private String slugGroupProduct;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameGroupProduct() {
    return nameGroupProduct;
  }

  public void setNameGroupProduct(String nameGroupProduct) {
    this.nameGroupProduct = nameGroupProduct;
  }

  public String getSlugGroupProduct() {
    return slugGroupProduct;
  }

  public void setSlugGroupProduct(String slugGroupProduct) {
    this.slugGroupProduct = slugGroupProduct;
  }
}
