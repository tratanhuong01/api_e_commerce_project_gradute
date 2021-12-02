package com.api.api_e_commerce_project_gradute.memory;

import com.api.api_e_commerce_project_gradute.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "memory")
public class Memory implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nameMemory;

  @Column
  private int type;

  @Column
  private Timestamp timeCreated;

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
