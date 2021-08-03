package com.api.api_e_commerce_project_gradute.DTO;

public class AccountLogin {
  private String emailOrPhone;
  private String password;

  public String getEmailOrPhone() {
    return emailOrPhone;
  }

  public void setEmailOrPhone(String emailOrPhone) {
    this.emailOrPhone = emailOrPhone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
