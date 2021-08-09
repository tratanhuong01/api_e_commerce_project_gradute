package com.api.api_e_commerce_project_gradute.product_output;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product_output")
public class ProductOutput {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "id_product")
  private Product productOutput;

  @Column
  private int amount;

  @Column
  private int priceOutput;

  @Column
  private Timestamp timeOutput;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getProductOutput() {
    return productOutput;
  }

  public void setProductOutput(Product productOutput) {
    this.productOutput = productOutput;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getPriceOutput() {
    return priceOutput;
  }

  public void setPriceOutput(int priceOutput) {
    this.priceOutput = priceOutput;
  }

  public Timestamp getTimeOutput() {
    return timeOutput;
  }

  public void setTimeOutput(Timestamp timeOutput) {
    this.timeOutput = timeOutput;
  }
}
