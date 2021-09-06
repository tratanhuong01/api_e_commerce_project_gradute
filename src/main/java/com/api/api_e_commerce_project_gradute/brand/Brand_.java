package com.api.api_e_commerce_project_gradute.brand;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Brand.class)
public class Brand_ {

  public static volatile SingularAttribute<Brand, String> id;
  public static volatile SingularAttribute<Brand, String> nameBrand;
  public static volatile SingularAttribute<Brand, Integer> type;

}
