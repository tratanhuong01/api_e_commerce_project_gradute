package com.api.api_e_commerce_project_gradute.color;

import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product_input.ProductInput;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "color")
public class Color {

  @Id
  private String id;

  @OneToMany(mappedBy = "colorProduct",cascade = CascadeType.ALL)
  private Set<Product> colorProduct = new HashSet<>();;

  @Column
  private String code;

  @Column
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
