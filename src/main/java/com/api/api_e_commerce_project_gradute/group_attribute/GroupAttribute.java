package com.api.api_e_commerce_project_gradute.group_attribute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "group_attribute")
public class GroupAttribute {

  @Id
  private String id;

  @Column
  private String nameGroupAttribute;

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

  public String getNameGroupAttribute() {
    return nameGroupAttribute;
  }

  public void setNameGroupAttribute(String nameGroupAttribute) {
    this.nameGroupAttribute = nameGroupAttribute;
  }
}
