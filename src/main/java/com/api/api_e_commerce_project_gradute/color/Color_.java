package com.api.api_e_commerce_project_gradute.color;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Color.class)
public class Color_ {

  public static volatile SetAttribute<Color,Product> colorProduct;
  public static volatile SingularAttribute<Color,Long> id;
  public static volatile SingularAttribute<Color,String> code;
  public static volatile SingularAttribute<Color,String> description;


}
