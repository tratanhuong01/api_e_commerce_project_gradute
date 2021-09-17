package com.api.api_e_commerce_project_gradute.messages;

import com.api.api_e_commerce_project_gradute.DTO.messages.MessagesCustom;
import com.api.api_e_commerce_project_gradute.group_chat.GroupChatRepository;
import com.api.api_e_commerce_project_gradute.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessagesService {

  @Autowired
  MessagesRepository messagesRepository;

  @Autowired
  GroupChatRepository groupChatRepository;

  @Autowired
  UserRepository userRepository;

  public List<Messages> getAllMessages() {
    return messagesRepository.findAll();
  }

  public Messages addMessages(Messages messages) {
    messages.setTimeCreated(new Timestamp(new Date().getTime()));
    return messagesRepository.save(messages);
  }

  public void deleteMessages(Messages messages) {
     messagesRepository.delete(messages);
     return;
  }

  public List<MessagesCustom> getMessagesByIdUser(String idUser) {
    List<MessagesCustom> messagesCustomList = new ArrayList<>();
    List<Long> stringList = messagesRepository.getDistinctIdGroupChatByIdUser(idUser);
    for (Long longData: stringList)
      messagesCustomList.add(getMessageByIdGroupChat(longData));
    return messagesCustomList;
  }

  public MessagesCustom getMessageByIdGroupChat(Long idGroupChat) {
    MessagesCustom messagesCustom = new MessagesCustom();
    messagesCustom.setGroupChat(groupChatRepository.getGroupChatByIdGroupChat(idGroupChat));
    messagesCustom.setMessagesList(messagesRepository.getMessageByIdGroupChat(idGroupChat));
    messagesCustom.setCustomer(messagesRepository.getCustomer(idGroupChat));
    messagesCustom.setAdmin(userRepository.getAdmin(idGroupChat));
    return messagesCustom;
  }

}
