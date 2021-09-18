package com.api.api_e_commerce_project_gradute.info_product;

import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "info_product")
public class InfoProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  @JoinColumn(name = "id_product")
  private Product infoProduct;

  @Column
  private int priceInput;

  @Column
  private int priceOutput;

  @Column
  private int sale;

  @Column
  private int itemCurrent;

  @Column
  private int itemSold;

  @Column
  private int typeInfoProduct;

  @Column
  private int review;

  @Column
  private Timestamp timeInput;

  public Timestamp getTimeInput() {
    return timeInput;
  }

  public void setTimeInput(Timestamp timeInput) {
    this.timeInput = timeInput;
  }

  public int getReview() {
    return review;
  }

  public void setReview(int review) {
    this.review = review;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getInfoProduct() {
    return infoProduct;
  }

  public void setInfoProduct(Product infoProduct) {
    this.infoProduct = infoProduct;
  }

  public int getPriceInput() {
    return priceInput;
  }

  public void setPriceInput(int priceInput) {
    this.priceInput = priceInput;
  }

  public int getPriceOutput() {
    return priceOutput;
  }

  public void setPriceOutput(int priceOutput) {
    this.priceOutput = priceOutput;
  }

  public int getSale() {
    return sale;
  }

  public void setSale(int sale) {
    this.sale = sale;
  }

  public int getItemCurrent() {
    return itemCurrent;
  }

  public void setItemCurrent(int itemCurrent) {
    this.itemCurrent = itemCurrent;
  }

  public int getItemSold() {
    return itemSold;
  }

  public void setItemSold(int itemSold) {
    this.itemSold = itemSold;
  }

  public int getTypeInfoProduct() {
    return typeInfoProduct;
  }

  public void setTypeInfoProduct(int typeInfoProduct) {
    this.typeInfoProduct = typeInfoProduct;
  }
}
