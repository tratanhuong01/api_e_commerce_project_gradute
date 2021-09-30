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

  @Column
  private int amountInput;

  @Column
  private int saleDefault;

  @Column
  private Timestamp timeStartSale;

  @Column
  private Timestamp timeEndSale;

  public int getSaleDefault() {
    return saleDefault;
  }

  public void setSaleDefault(int saleDefault) {
    this.saleDefault = saleDefault;
  }

  public Timestamp getTimeStartSale() {
    return timeStartSale;
  }

  public void setTimeStartSale(Timestamp timeStartSale) {
    this.timeStartSale = timeStartSale;
  }

  public Timestamp getTimeEndSale() {
    return timeEndSale;
  }

  public void setTimeEndSale(Timestamp timeEndSale) {
    this.timeEndSale = timeEndSale;
  }

  public int getAmountInput() {
    return amountInput;
  }

  public void setAmountInput(int amountInput) {
    this.amountInput = amountInput;
  }

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
