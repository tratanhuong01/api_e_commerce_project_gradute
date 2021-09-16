package com.api.api_e_commerce_project_gradute.group_chat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_chat")
public class GroupChat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String fullName;

  @Column
  private String phone;

  @Column
  private String sex;

  @Column
  private String avatar;

  @Column
  private int typeGroupChat;

  @Column
  private Timestamp timeCreated;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getTypeGroupChat() {
    return typeGroupChat;
  }

  public void setTypeGroupChat(int typeGroupChat) {
    this.typeGroupChat = typeGroupChat;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }
}
