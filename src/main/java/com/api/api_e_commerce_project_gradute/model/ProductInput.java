package com.api.api_e_commerce_project_gradute.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product_input")
public class ProductInput {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "id_product")
  private Product productInput;

  @Column
  private int amount;

  @Column
  private int priceInput;

  @Column
  private Timestamp timeInput;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getProductInput() {
    return productInput;
  }

  public void setProductInput(Product productInput) {
    this.productInput = productInput;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getPriceInput() {
    return priceInput;
  }

  public void setPriceInput(int priceInput) {
    this.priceInput = priceInput;
  }

  public Timestamp getTimeInput() {
    return timeInput;
  }

  public void setTimeInput(Timestamp timeInput) {
    this.timeInput = timeInput;
  }
}
