package com.api.api_e_commerce_project_gradute.review_product;

import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "review_product")
public class ReviewProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User userReviewProduct;

  @ManyToOne
  @JoinColumn(name = "id_product")
  private Product productReview;

  @Column
  private String fullName;

  @Column
  private String email;

  @Column
  private String content;

  @Column
  private String image;

  @Column
  private int star;

  @Column
  private int useful;

  @Column
  private int violate;

  @Column
  private int level;

  @Column
  private String reply;

  @Column
  private int type;

  @Column
  private Timestamp timeCreated;

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUserReviewProduct() {
    return userReviewProduct;
  }

  public void setUserReviewProduct(User userReviewProduct) {
    this.userReviewProduct = userReviewProduct;
  }

  public Product getProductReview() {
    return productReview;
  }

  public void setProductReview(Product productReview) {
    this.productReview = productReview;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }

  public int getUseful() {
    return useful;
  }

  public void setUseful(int useful) {
    this.useful = useful;
  }

  public int getViolate() {
    return violate;
  }

  public void setViolate(int violate) {
    this.violate = violate;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getReply() {
    return reply;
  }

  public void setReply(String reply) {
    this.reply = reply;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
