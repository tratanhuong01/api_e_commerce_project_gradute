package com.api.api_e_commerce_project_gradute.DTO;

import com.api.api_e_commerce_project_gradute.user.User;

public class DataSendMail {

  private String email;
  private String topic;
  private String body;
  private String status;
  private User user;
  private Integer typeSendMail;

  public Integer getTypeSendMail() {
    return typeSendMail;
  }

  public void setTypeSendMail(Integer typeSendMail) {
    this.typeSendMail = typeSendMail;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
