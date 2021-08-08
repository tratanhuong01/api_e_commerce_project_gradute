package com.api.api_e_commerce_project_gradute.memory;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "memory")
public class Memory {

  @Id
  private String id;

  @OneToMany(mappedBy = "memoryProduct",cascade = CascadeType.ALL)
  private Set<Product> memoryProduct = new HashSet<>();

  @Column
  private String nameMemory;

  @Column
  private int type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameMemory() {
    return nameMemory;
  }

  public void setNameMemory(String nameMemory) {
    this.nameMemory = nameMemory;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
