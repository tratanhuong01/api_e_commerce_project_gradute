package com.api.api_e_commerce_project_gradute.wish_list;

import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "wish_list")
public class WishList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User wishListUser;

  @ManyToOne
  @JoinColumn(name = "id_product")
  private Product wishListProduct;

  @Column
  private int amount;

  @Column
  private Timestamp timeCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getWishListUser() {
    return wishListUser;
  }

  public void setWishListUser(User wishListUser) {
    this.wishListUser = wishListUser;
  }

  public Product getWishListProduct() {
    return wishListProduct;
  }

  public void setWishListProduct(Product wishListProduct) {
    this.wishListProduct = wishListProduct;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
