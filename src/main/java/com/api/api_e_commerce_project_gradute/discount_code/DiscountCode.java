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
  private String nameDiscountCode;

  @Column
  private String timeStart;

  @Column
  private String timeExpired;

  @Column
  private int percent;

  @Column
  private int amount;

  @Column
  private int type;

  @Column
  private int min;

  @Column
  private int max;

  @Column
  private Timestamp timeCreated;

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public int getPercent() {
    return percent;
  }

  public void setPercent(int percent) {
    this.percent = percent;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public String getNameDiscountCode() {
    return nameDiscountCode;
  }

  public void setNameDiscountCode(String nameDiscountCode) {
    this.nameDiscountCode = nameDiscountCode;
  }

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

  public String getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(String timeStart) {
    this.timeStart = timeStart;
  }

  public String getTimeExpired() {
    return timeExpired;
  }

  public void setTimeExpired(String timeExpired) {
    this.timeExpired = timeExpired;
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
