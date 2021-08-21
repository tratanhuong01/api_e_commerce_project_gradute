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
  private String id;

  @OneToMany(mappedBy = "billDetail")
  private Set<BillDetail> billDetail = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User billUser;

  @Column
  private int status;

  @ManyToOne
  @JoinColumn(name = "id_payment_method")
  private PaymentMethod paymentMethodBill;

  @ManyToOne
  @JoinColumn(name = "id_bank")
  private Bank bankBill;

  @ManyToOne
  @JoinColumn(name = "id_address")
  private Address addressBill;

  @Column
  private int total;

  @Column
  private Timestamp timeCreated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public Bank getBankBill() {
    return bankBill;
  }

  public void setBankBill(Bank bankBill) {
    this.bankBill = bankBill;
  }

  public Address getAddressBill() {
    return addressBill;
  }

  public void setAddressBill(Address addressBill) {
    this.addressBill = addressBill;
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
}
