package com.api.api_e_commerce_project_gradute.discount_code;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "discount_code")
public class DiscountCode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String code;

  @Column
  private Timestamp timeStart;

  @Column
  private Timestamp timeExpired;

  @Column
  private int percentOrPrice;

  @Column
  private int amount;

  @Column
  private int type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Timestamp getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(Timestamp timeStart) {
    this.timeStart = timeStart;
  }

  public Timestamp getTimeExpired() {
    return timeExpired;
  }

  public void setTimeExpired(Timestamp timeExpired) {
    this.timeExpired = timeExpired;
  }

  public int getPercentOrPrice() {
    return percentOrPrice;
  }

  public void setPercentOrPrice(int percentOrPrice) {
    this.percentOrPrice = percentOrPrice;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
