package com.api.api_e_commerce_project_gradute.password_reset;

import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "password_reset")

public class PasswordReset {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User passwordResetUser;

  @Column
  private String code;

  @Column
  private Timestamp timeCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getPasswordResetUser() {
    return passwordResetUser;
  }

  public void setPasswordResetUser(User passwordResetUser) {
    this.passwordResetUser = passwordResetUser;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
