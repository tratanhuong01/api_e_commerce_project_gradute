package com.api.api_e_commerce_project_gradute.role;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "role")
public class Role {

  @Id
  private String id;

  @Column
  private String nameRole;

  @Column
  private int typeRole;

  @Column
  private Timestamp timeCreated;

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameRole() {
    return nameRole;
  }

  public void setNameRole(String nameRole) {
    this.nameRole = nameRole;
  }

  public int getTypeRole() {
    return typeRole;
  }

  public void setTypeRole(int typeRole) {
    this.typeRole = typeRole;
  }
}
