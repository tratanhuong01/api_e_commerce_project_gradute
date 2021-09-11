package com.api.api_e_commerce_project_gradute.discount_code_user;

import com.api.api_e_commerce_project_gradute.discount_code.DiscountCode;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;

@Entity
@Table(name = "discount_code_user")
public class DiscountCodeUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User userDiscountCode;

  @ManyToOne
  @JoinColumn(name = "id_discount_code")
  private DiscountCode discountCode;

  @Column
  private int isUsed;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUserDiscountCode() {
    return userDiscountCode;
  }

  public void setUserDiscountCode(User userDiscountCode) {
    this.userDiscountCode = userDiscountCode;
  }

  public DiscountCode getDiscountCode() {
    return discountCode;
  }

  public void setDiscountCode(DiscountCode discountCode) {
    this.discountCode = discountCode;
  }

  public int getIsUsed() {
    return isUsed;
  }

  public void setIsUsed(int isUsed) {
    this.isUsed = isUsed;
  }
}
