package com.api.api_e_commerce_project_gradute.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sale")
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "id_product")
  private Product productSale;

  @Column
  private String percent;

  @Column
  private Timestamp timeStart;

  @Column
  private Timestamp timeEnd;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getProductSale() {
    return productSale;
  }

  public void setProductSale(Product productSale) {
    this.productSale = productSale;
  }

  public String getPercent() {
    return percent;
  }

  public void setPercent(String percent) {
    this.percent = percent;
  }

  public Timestamp getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(Timestamp timeStart) {
    this.timeStart = timeStart;
  }

  public Timestamp getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(Timestamp timeEnd) {
    this.timeEnd = timeEnd;
  }
}
