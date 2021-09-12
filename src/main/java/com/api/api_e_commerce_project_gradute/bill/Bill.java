package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.address.Address;
import com.api.api_e_commerce_project_gradute.bank.Bank;
import com.api.api_e_commerce_project_gradute.bill_detail.BillDetail;
import com.api.api_e_commerce_project_gradute.payment_method.PaymentMethod;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "billDetail")
  private Set<BillDetail> billDetail = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User billUser;

  @Column
  private int status;

  @ManyToOne
  @JoinColumn(name = "id_method_payment")
  private PaymentMethod paymentMethodBill;

  @Column
  private String bank;

  @Column
  private String address;

  @Column
  private int sale;

  @Column
  private int fee;

  @Column
  private int total;

  @Column
  private Timestamp timeCreated;

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getBillUser() {
    return billUser;
  }

  public void setBillUser(User billUser) {
    this.billUser = billUser;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public PaymentMethod getPaymentMethodBill() {
    return paymentMethodBill;
  }

  public void setPaymentMethodBill(PaymentMethod paymentMethodBill) {
    this.paymentMethodBill = paymentMethodBill;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public Set<BillDetail> getBillDetail() {
    return billDetail;
  }

  public void setBillDetail(Set<BillDetail> billDetail) {
    this.billDetail = billDetail;
  }

  public int getSale() {
    return sale;
  }

  public void setSale(int sale) {
    this.sale = sale;
  }

  public int getFee() {
    return fee;
  }

  public void setFee(int fee) {
    this.fee = fee;
  }
}
