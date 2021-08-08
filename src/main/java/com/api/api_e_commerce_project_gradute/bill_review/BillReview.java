package com.api.api_e_commerce_project_gradute.bill_review;

import com.api.api_e_commerce_project_gradute.bill.Bill;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bill_review")
public class BillReview {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private User reviewBillUser;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_bill")
  private Bill billReview;

  @Column
  private int star;

  @Column
  private Timestamp timeCreated;

  public User getReviewBillUser() {
    return reviewBillUser;
  }

  public void setReviewBillUser(User reviewBillUser) {
    this.reviewBillUser = reviewBillUser;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Bill getBillReview() {
    return billReview;
  }

  public void setBillReview(Bill billReview) {
    this.billReview = billReview;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
