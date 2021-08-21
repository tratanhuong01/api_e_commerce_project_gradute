package com.api.api_e_commerce_project_gradute.payment_method;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {
  @Id
  private Long id;

  @Column
  private String namePaymentMethod;

  @Column
  private int typePaymentMethod;

  @Column
  private int isShow;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNamePaymentMethod() {
    return namePaymentMethod;
  }

  public void setNamePaymentMethod(String namePaymentMethod) {
    this.namePaymentMethod = namePaymentMethod;
  }

  public int getTypePaymentMethod() {
    return typePaymentMethod;
  }

  public void setTypePaymentMethod(int typePaymentMethod) {
    this.typePaymentMethod = typePaymentMethod;
  }

  public int getIsShow() {
    return isShow;
  }

  public void setShow(int ísShow) {
    this.isShow = isShow;
  }
}
