package com.api.api_e_commerce_project_gradute.image_other;

import com.api.api_e_commerce_project_gradute.line_product.LineProduct;

import javax.persistence.*;

@Entity
@Table(name = "image_other")
public class ImageOther {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_line_product")
  private LineProduct lineProductImage;

  @Column
  private String src;

  @Column
  private int type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LineProduct getLineProductImage() {
    return lineProductImage;
  }

  public void setLineProductImage(LineProduct lineProductImage) {
    this.lineProductImage = lineProductImage;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
