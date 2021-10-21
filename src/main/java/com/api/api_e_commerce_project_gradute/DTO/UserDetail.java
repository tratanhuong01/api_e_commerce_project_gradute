package com.api.api_e_commerce_project_gradute.DTO;

import com.api.api_e_commerce_project_gradute.user.User;

public class UserDetail {
  private User user;
  private String token;
  private String message;
  private int status;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
