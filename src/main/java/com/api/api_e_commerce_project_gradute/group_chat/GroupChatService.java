package com.api.api_e_commerce_project_gradute.group_chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class GroupChatService {

  @Autowired
  GroupChatRepository groupChatRepository;

  public List<GroupChat> getAllGroupChat() {
    return groupChatRepository.findAll();
  }

  public GroupChat addGroupChat(GroupChat groupChat) {
    groupChat.setTimeCreated(new Timestamp(new Date().getTime()));
    return groupChatRepository.save(groupChat);
  }

  public void deleteGroupChat(GroupChat groupChat) {
    groupChatRepository.delete(groupChat);
    return;
  }

  public GroupChat updateGroupChat(GroupChat groupChat) {
    return groupChatRepository.save(groupChat);
  }

}
