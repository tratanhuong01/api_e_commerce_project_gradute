package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.brand.Brand;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.ram.Ram;
import com.api.api_e_commerce_project_gradute.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {
  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User productUser;

  @ManyToOne
  @JoinColumn(name = "id_memory")
  private Memory memoryProduct;

  @ManyToOne
  @JoinColumn(name = "id_line_product")
  private LineProduct lineProduct;

  @ManyToOne
  @JoinColumn(name = "id_color")
  private Color colorProduct;

  @ManyToOne
  @JoinColumn(name = "id_ram")
  private Ram ramProduct;

  @ManyToOne
  @JoinColumn(name = "id_brand")
  private Brand brandProduct;

  @ManyToOne
  @JoinColumn(name = "id_image")
  private Image imageProduct;

  @Column
  private int isShow;

  @Column
  private String slug;

  @Column
  private String describeProduct;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getProductUser() {
    return productUser;
  }

  public void setProductUser(User productUser) {
    this.productUser = productUser;
  }

  public Memory getMemoryProduct() {
    return memoryProduct;
  }

  public void setMemoryProduct(Memory memoryProduct) {
    this.memoryProduct = memoryProduct;
  }

  public LineProduct getLineProduct() {
    return lineProduct;
  }

  public void setLineProduct(LineProduct lineProduct) {
    this.lineProduct = lineProduct;
  }

  public Color getColorProduct() {
    return colorProduct;
  }

  public void setColorProduct(Color colorProduct) {
    this.colorProduct = colorProduct;
  }

  public Ram getRamProduct() {
    return ramProduct;
  }

  public void setRamProduct(Ram ramProduct) {
    this.ramProduct = ramProduct;
  }

  public Brand getBrandProduct() {
    return brandProduct;
  }

  public void setBrandProduct(Brand brandProduct) {
    this.brandProduct = brandProduct;
  }

  public Image getImageProduct() {
    return imageProduct;
  }

  public void setImageProduct(Image imageProduct) {
    this.imageProduct = imageProduct;
  }

  public int getIsShow() {
    return isShow;
  }

  public void setIsShow(int isShow) {
    this.isShow = isShow;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getDescribeProduct() {
    return describeProduct;
  }

  public void setDescribeProduct(String describeProduct) {
    this.describeProduct = describeProduct;
  }
}
