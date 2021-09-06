package com.api.api_e_commerce_project_gradute.detail_function_product;

import com.api.api_e_commerce_project_gradute.function_product.FunctionProduct;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DetailFunctionProduct.class)
public class DetailFunctionProduct_ {

  public static volatile SingularAttribute<DetailFunctionProduct, LineProduct> lineProductFunctionProduct;
  public static volatile SingularAttribute<DetailFunctionProduct,Long> id;
  public static volatile SingularAttribute<DetailFunctionProduct, FunctionProduct> functionProductDetail;

}
