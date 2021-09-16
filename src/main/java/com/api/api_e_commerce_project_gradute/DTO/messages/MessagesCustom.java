package com.api.api_e_commerce_project_gradute.DTO.messages;

import com.api.api_e_commerce_project_gradute.group_chat.GroupChat;
import com.api.api_e_commerce_project_gradute.messages.Messages;
import com.api.api_e_commerce_project_gradute.user.User;

import java.util.List;

public class MessagesCustom {
  private GroupChat groupChat;
  private List<Messages> messagesList;
  private String customer;
  private User admin;

  public GroupChat getGroupChat() {
    return groupChat;
  }

  public void setGroupChat(GroupChat groupChat) {
    this.groupChat = groupChat;
  }

  public List<Messages> getMessagesList() {
    return messagesList;
  }

  public void setMessagesList(List<Messages> messagesList) {
    this.messagesList = messagesList;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public User getAdmin() {
    return admin;
  }

  public void setAdmin(User admin) {
    this.admin = admin;
  }
}
