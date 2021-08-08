package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.brand.Brand;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.sale.Sale;
import com.api.api_e_commerce_project_gradute.product_input.ProductInput;
import com.api.api_e_commerce_project_gradute.product_output.ProductOutput;
import com.api.api_e_commerce_project_gradute.size.Size;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import javax.sound.sampled.Line;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
  @Id
  private String id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private User productUser;

  @OneToMany(mappedBy = "productInput")
  private Set<ProductInput> productInput = new HashSet<>();

  @OneToMany(mappedBy = "productOutput")
  private Set<ProductOutput> productOutput = new HashSet<>();

  @OneToMany(mappedBy = "productSale")
  private Set<Sale> productSale = new HashSet<>();;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_memory")
  private Memory memoryProduct;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_line_product")
  private LineProduct lineProduct;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_color")
  private Color colorProduct;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_size")
  private Size sizeProduct;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_brand")
  private Brand brandProduct;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_image")
  private Image imageProduct;

  @Column
  private int isShow;

  @Column
  private String slug;

  @Column
  private String describeProduct;

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
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

  public Size getSizeProduct() {
    return sizeProduct;
  }

  public void setSizeProduct(Size sizeProduct) {
    this.sizeProduct = sizeProduct;
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
