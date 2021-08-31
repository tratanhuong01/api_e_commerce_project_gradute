package com.api.api_e_commerce_project_gradute.attribute;

import com.api.api_e_commerce_project_gradute.group_attribute.GroupAttribute;

import javax.persistence.*;

@Entity
@Table(name = "attribute")
public class Attribute {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "id_group_attribute")
  private GroupAttribute groupAttribute;

  @Column
  private String nameAttribute;

  @Column
  private int typeAttribute;

  public GroupAttribute getGroupAttribute() {
    return groupAttribute;
  }

  public void setGroupAttribute(GroupAttribute groupAttribute) {
    this.groupAttribute = groupAttribute;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
