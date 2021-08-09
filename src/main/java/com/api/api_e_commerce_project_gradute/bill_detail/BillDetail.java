package com.api.api_e_commerce_project_gradute.bill_detail;

import com.api.api_e_commerce_project_gradute.bill.Bill;
import com.api.api_e_commerce_project_gradute.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_bill")
  private Bill billDetail;

  @ManyToOne
  @JoinColumn(name = "id_product")
  private Product productDetailBill;

  @Column
  private int amount;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Bill getBillDetail() {
    return billDetail;
  }

  public void setBillDetail(Bill billDetail) {
    this.billDetail = billDetail;
  }

  public Product getProductDetailBill() {
    return productDetailBill;
  }

  public void setProductDetailBill(Product productDetailBill) {
    this.productDetailBill = productDetailBill;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
