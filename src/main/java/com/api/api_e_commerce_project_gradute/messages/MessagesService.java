package com.api.api_e_commerce_project_gradute.messages;

import com.api.api_e_commerce_project_gradute.DTO.messages.MessagesCustom;
import com.api.api_e_commerce_project_gradute.group_chat.GroupChatRepository;
import com.api.api_e_commerce_project_gradute.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    return messagesRepository.save(messages);
  }

  public void deleteMessages(Messages messages) {
     messagesRepository.delete(messages);
     return;
  }

  public List<MessagesCustom> getMessagesByIdUser(String idUser) {
    List<MessagesCustom> messagesCustomList = new ArrayList<>();
    List<Long> stringList = groupChatRepository.getDistinctIdGroupChatByIdUser(idUser);
    for (Long longData: stringList) {
      MessagesCustom messagesCustom = new MessagesCustom();
      messagesCustom.setGroupChat(groupChatRepository.getGroupChatByIdGroupChat(longData));
      messagesCustom.setMessagesList(messagesRepository.getMessageByIdGroupChat(longData));
      messagesCustom.setCustomer(messagesRepository.getCustomer(longData));
      messagesCustom.setAdmin(userRepository.getAdmin(longData));
      messagesCustomList.add(messagesCustom);
    }
    return messagesCustomList;
  }

}
