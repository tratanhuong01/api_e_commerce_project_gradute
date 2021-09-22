package com.api.api_e_commerce_project_gradute.memory;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel(Memory.class)
public class Memory_ {

  public static volatile SetAttribute<Memory,Product> memoryProduct;
  public static volatile SingularAttribute<Memory, Long> id;
  public static volatile SingularAttribute<Memory, Integer> type;
  public static volatile SingularAttribute<Memory, String> nameMemory;
  public static volatile SingularAttribute<Memory, Timestamp> timeCreated;

}
