package com.api.api_e_commerce_project_gradute.function_product;

import javax.persistence.*;

@Entity
@Table(name = "function_product")
public class FunctionProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nameFunctionProduct;

  @Column
  private int typeFunctionProduct;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameFunctionProduct() {
    return nameFunctionProduct;
  }

  public void setNameFunctionProduct(String nameFunctionProduct) {
    this.nameFunctionProduct = nameFunctionProduct;
  }

  public int getTypeFunctionProduct() {
    return typeFunctionProduct;
  }

  public void setTypeFunctionProduct(int typeFunctionProduct) {
    this.typeFunctionProduct = typeFunctionProduct;
  }
}
