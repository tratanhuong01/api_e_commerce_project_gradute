package com.api.api_e_commerce_project_gradute.brand;

import com.api.api_e_commerce_project_gradute.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand {
  @Id
  private String id;

  @Column
  private String nameBrand;

  @Column
  private String imageBrand;

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

  public String getImageBrand() {
    return imageBrand;
  }

  public void setImageBrand(String imageBrand) {
    this.imageBrand = imageBrand;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
