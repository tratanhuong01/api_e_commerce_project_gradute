package com.api.api_e_commerce_project_gradute.ram;

import com.api.api_e_commerce_project_gradute.brand.Brand;
import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ram.class)
public class Ram_ {

  public static volatile SetAttribute<Ram,Product> ramProduct;
  public static volatile SingularAttribute<Ram, Long> id;
  public static volatile SingularAttribute<Ram, String> nameRam;
  public static volatile SingularAttribute<Ram, Integer> isShow;

}
