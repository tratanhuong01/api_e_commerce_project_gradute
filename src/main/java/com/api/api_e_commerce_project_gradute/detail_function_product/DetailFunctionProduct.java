package com.api.api_e_commerce_project_gradute.detail_function_product;

import com.api.api_e_commerce_project_gradute.function_product.FunctionProduct;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;

import javax.persistence.*;

@Entity
@Table(name = "detail_function_product")
public class DetailFunctionProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_line_product")
  private LineProduct lineProductFunctionProduct;

  @ManyToOne
  @JoinColumn(name = "id_function_product")
  private FunctionProduct functionProductDetail;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LineProduct getLineProductFunctionProduct() {
    return lineProductFunctionProduct;
  }

  public void setLineProductFunctionProduct(LineProduct lineProductFunctionProduct) {
    this.lineProductFunctionProduct = lineProductFunctionProduct;
  }

  public FunctionProduct getFunctionProductDetail() {
    return functionProductDetail;
  }

  public void setFunctionProductDetail(FunctionProduct functionProductDetail) {
    this.functionProductDetail = functionProductDetail;
  }
}
