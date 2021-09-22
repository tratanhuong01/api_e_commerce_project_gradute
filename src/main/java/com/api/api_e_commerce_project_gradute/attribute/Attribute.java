package com.api.api_e_commerce_project_gradute.attribute;

import com.api.api_e_commerce_project_gradute.group_attribute.GroupAttribute;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "attribute")
public class Attribute {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_group_attribute")
  private GroupAttribute groupAttribute;

  @Column
  private String nameAttribute;

  @Column
  private int typeAttribute;

  @Column
  private Timestamp timeCreated;

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public GroupAttribute getGroupAttribute() {
    return groupAttribute;
  }

  public void setGroupAttribute(GroupAttribute groupAttribute) {
    this.groupAttribute = groupAttribute;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameAttribute() {
    return nameAttribute;
  }

  public void setNameAttribute(String nameAttribute) {
    this.nameAttribute = nameAttribute;
  }

  public int getTypeAttribute() {
    return typeAttribute;
  }

  public void setTypeAttribute(int typeAttribute) {
    this.typeAttribute = typeAttribute;
  }
}
