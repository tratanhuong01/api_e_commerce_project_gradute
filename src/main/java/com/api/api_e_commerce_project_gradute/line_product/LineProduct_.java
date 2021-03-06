package com.api.api_e_commerce_project_gradute.line_product;

import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProduct;
import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;
import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel(LineProduct.class)
public class LineProduct_ {

  public static volatile SetAttribute<LineProduct, Product> lineProduct;
  public static volatile SetAttribute<LineProduct, DetailFunctionProduct> lineProductFunctionProduct;
  public static volatile SetAttribute<LineProduct, GroupProduct> groupProduct;
  public static volatile SingularAttribute<LineProduct,String> id;
  public static volatile SingularAttribute<LineProduct,String> nameLineProduct;
  public static volatile SingularAttribute<LineProduct, Timestamp> timeCreated;

}
