package com.api.api_e_commerce_project_gradute.attribute_product;

import com.api.api_e_commerce_project_gradute.attribute.Attribute;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;

import javax.persistence.*;

@Entity
@Table(name = "attribute_product")
public class AttributeProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_line_product")
  private LineProduct lineProductAttribute;

  @ManyToOne
  @JoinColumn(name = "id_attribute")
  private Attribute attributeProduct;

  @Column
  private int display;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LineProduct getLineProductAttribute() {
    return lineProductAttribute;
  }

  public void setLineProductAttribute(LineProduct lineProductAttribute) {
    this.lineProductAttribute = lineProductAttribute;
  }

  public Attribute getAttributeProduct() {
    return attributeProduct;
  }

  public void setAttributeProduct(Attribute attributeProduct) {
    this.attributeProduct = attributeProduct;
  }

  public int getDisplay() {
    return display;
  }

  public void setDisplay(int display) {
    this.display = display;
  }
}
