package com.api.api_e_commerce_project_gradute.brand;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand {
  @Id
  private String id;

  @OneToMany(mappedBy = "brandProduct")
  private Set<Product> brandProduct = new HashSet<>();;

  @Column
  private String nameBrand;

  @Column
  private int type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getNameBrand() {
    return nameBrand;
  }

  public void setNameBrand(String nameBrand) {
    this.nameBrand = nameBrand;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
