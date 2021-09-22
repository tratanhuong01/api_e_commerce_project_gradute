package com.api.api_e_commerce_project_gradute.brand;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel(Brand.class)
public class Brand_ {

  public static volatile SingularAttribute<Brand, String> id;
  public static volatile SingularAttribute<Brand, String> nameBrand;
  public static volatile SingularAttribute<Brand, Integer> type;
  public static volatile SingularAttribute<Brand, String> imageBrand;
  public static volatile SingularAttribute<Brand, Timestamp> timeCreated;

}
