package com.api.api_e_commerce_project_gradute.image;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "image")
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "imageProduct",cascade = CascadeType.ALL)
  private Set<Product> imageProduct = new HashSet<>();

  @Column
  private String src;

  @Column
  private String alt;

  @Column
  private int type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
