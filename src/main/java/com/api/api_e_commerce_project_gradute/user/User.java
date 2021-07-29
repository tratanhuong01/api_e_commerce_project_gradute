package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.bill.Bill;
import com.api.api_e_commerce_project_gradute.bill_review.BillReview;
import com.api.api_e_commerce_project_gradute.comment.Comment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
  @Id
  private String id;

  @OneToMany(mappedBy = "billUser")
  private Set<Bill> billUser = new HashSet<>();;

  @OneToMany(mappedBy = "cartUser")
  private Set<User> cartUser = new HashSet<>();;

  @OneToMany(mappedBy = "reviewBillUser")
  private Set<BillReview> reviewBillUser = new HashSet<>();;

  @OneToMany(mappedBy = "commentUser")
  private Set<Comment> commentUser = new HashSet<>();;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private Date birthday;

  @Column
  private String sex;

  @Column
  private String email;

  @Column
  private String phone;

  @Column
  private int type;

  @Column
  private Timestamp timeCreated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
