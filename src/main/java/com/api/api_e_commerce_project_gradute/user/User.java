package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.bill.Bill;
import com.api.api_e_commerce_project_gradute.bill_review.BillReview;
import com.api.api_e_commerce_project_gradute.comment.Comment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
  private String password;

  @Column
  private String codeEmail;

  @Column
  private String codePhone;

  @Column
  private int isVerifyEmail;

  @Column
  private int isVerifyPhone;

  @Column
  private int type;

  @Column
  private Timestamp timeCreated;

  public String getCodeEmail() {
    return codeEmail;
  }

  public void setCodeEmail(String codeEmail) {
    this.codeEmail = codeEmail;
  }

  public String getCodePhone() {
    return codePhone;
  }

  public void setCodePhone(String codePhone) {
    this.codePhone = codePhone;
  }

  public int getIsVerifyEmail() {
    return isVerifyEmail;
  }

  public void setIsVerifyEmail(int isVerifyEmail) {
    this.isVerifyEmail = isVerifyEmail;
  }

  public int getIsVerifyPhone() {
    return isVerifyPhone;
  }

  public void setIsVerifyPhone(int isVerifyPhone) {
    this.isVerifyPhone = isVerifyPhone;
  }

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

  public void setBirthday(String birthday) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date parsed = format.parse(birthday);
    this.birthday = parsed;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
