package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.brand.Brand;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.ram.Ram;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ {

  public static volatile SingularAttribute<Product, Color> colorProduct;
  public static volatile SingularAttribute<Product, Memory> memoryProduct;
  public static volatile SingularAttribute<Product, Ram> ramProduct;
  public static volatile SingularAttribute<Product, Brand> brandProduct;
  public static volatile SingularAttribute<Product, String> id;
  public static volatile SingularAttribute<Product, Image> imageProduct;
  public static volatile SingularAttribute<Product, User> productUser;
  public static volatile SingularAttribute<Product, LineProduct> lineProduct;
  public static volatile SingularAttribute<Memory, Integer> isShow;
  public static volatile SingularAttribute<Memory, String> slug;
  public static volatile SingularAttribute<Memory, String> describeProduct;

}
