package com.api.api_e_commerce_project_gradute.cart;

import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private User userCart;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_product")
  private Product productCart;

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

  public User getUserCart() {
    return userCart;
  }

  public void setUserCart(User userCart) {
    this.userCart = userCart;
  }

  public Product getProductCart() {
    return productCart;
  }

  public void setProductCart(Product productCart) {
    this.productCart = productCart;
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
