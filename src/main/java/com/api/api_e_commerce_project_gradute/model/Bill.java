package com.api.api_e_commerce_project_gradute.model;

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

  @Column
  private int methodPayment;

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

  public int getMethodPayment() {
    return methodPayment;
  }

  public void setMethodPayment(int methodPayment) {
    this.methodPayment = methodPayment;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
