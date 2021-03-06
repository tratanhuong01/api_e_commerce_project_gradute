package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.bill.Bill;
import com.api.api_e_commerce_project_gradute.bill_review.BillReview;
import com.api.api_e_commerce_project_gradute.comment.Comment;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.role.Role;
import com.api.api_e_commerce_project_gradute.wish_list.WishList;
import org.hibernate.annotations.Formula;

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

  @OneToMany(mappedBy = "productUser")
  private Set<Product> productUser = new HashSet<>();

  @OneToMany(mappedBy = "wishListUser")
  private Set<WishList> wishListUser = new HashSet<>();


  @OneToMany(mappedBy = "billUser")
  private Set<Bill> billUser = new HashSet<>();;

  @OneToMany(mappedBy = "cartUser")
  private Set<User> cartUser = new HashSet<>();;

  @OneToMany(mappedBy = "reviewBillUser")
  private Set<BillReview> reviewBillUser = new HashSet<>();;

  @OneToMany(mappedBy = "commentUser")
  private Set<Comment> commentUser = new HashSet<>();;

  @ManyToOne
  @JoinColumn(name = "id_role")
  private Role userRole;

  @Column
  private String firstName;

  @Column
  private String lastName;
//
//  @Formula("concat(first_name,' ',last_name)")
//  private String concat;

  @Column
  private String birthday;

  @Column
  private String avatar;

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

  @Column
  private int status;

  @Column
  private int isRegister;

  @Column
  private String token;

  @Column
  private String googleId;

  @Column
  private String facebookId;

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getGoogleId() {
    return googleId;
  }

  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  public String getFacebookId() {
    return facebookId;
  }

  public void setFacebookId(String facebookId) {
    this.facebookId = facebookId;
  }

  public int getIsRegister() {
    return isRegister;
  }

  public void setIsRegister(int isRegister) {
    this.isRegister = isRegister;
  }

  public Role getUserRole() {
    return userRole;
  }

  public void setUserRole(Role userRole) {
    this.userRole = userRole;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

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

//  public Date getBirthday() {
//    return birthday;
//  }

//  public void setBirthday(String birthday) throws ParseException {
//    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//    Date parsed = format.parse(birthday);
//    this.birthday = parsed;
//  }


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
