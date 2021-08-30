package com.api.api_e_commerce_project_gradute.value_attribute;

import com.api.api_e_commerce_project_gradute.attribute.Attribute;

import javax.persistence.*;

@Entity
@Table(name = "value_attribute")
public class ValueAttribute {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_attribute")
  private Attribute valueAttribute;

  @Column
  private String value;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Attribute getValueAttribute() {
    return valueAttribute;
  }

  public void setValueAttribute(Attribute valueAttribute) {
    this.valueAttribute = valueAttribute;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
