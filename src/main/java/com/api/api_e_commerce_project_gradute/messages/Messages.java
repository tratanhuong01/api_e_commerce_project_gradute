package com.api.api_e_commerce_project_gradute.messages;

import com.api.api_e_commerce_project_gradute.group_chat.GroupChat;
import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class Messages {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User userMessages;

  @ManyToOne
  @JoinColumn(name = "id_group_chat")
  private GroupChat groupChatMessages;

  @Column
  private String guest;

  @Column
  private String content;

  @Column
  private String images;

  @Column
  private Timestamp timeCreated;

  @Column
  private int typeMessages;

  @Column
  private int isRead;

  public int getIsRead() {
    return isRead;
  }

  public void setIsRead(int isRead) {
    this.isRead = isRead;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUserMessages() {
    return userMessages;
  }

  public void setUserMessages(User userMessages) {
    this.userMessages = userMessages;
  }

  public String getGuest() {
    return guest;
  }

  public void setGuest(String guest) {
    this.guest = guest;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public Timestamp getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Timestamp timeCreated) {
    this.timeCreated = timeCreated;
  }

  public int getTypeMessages() {
    return typeMessages;
  }

  public void setTypeMessages(int typeMessages) {
    this.typeMessages = typeMessages;
  }

  public GroupChat getGroupChatMessages() {
    return groupChatMessages;
  }

  public void setGroupChatMessages(GroupChat groupChatMessages) {
    this.groupChatMessages = groupChatMessages;
  }
}
