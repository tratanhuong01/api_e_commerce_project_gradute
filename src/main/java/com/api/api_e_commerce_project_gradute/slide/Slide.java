package com.api.api_e_commerce_project_gradute.slide;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "slide")
public class Slide {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_product")
  private Product slideProduct;

  @Column
  private String image;

  @Column
  private String slogan;

  @Column
  private int type;

  @Column
  private Timestamp timeCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getSlideProduct() {
    return slideProduct;
  }

  public void setSlideProduct(Product slideProduct) {
    this.slideProduct = slideProduct;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getSlogan() {
    return slogan;
  }

  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
