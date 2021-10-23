package com.api.api_e_commerce_project_gradute.group_chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class GroupChatController {

  @Autowired
  GroupChatService groupChatService;

  @GetMapping("groupChats")
  public List<GroupChat> getAllGroupChats() {
    return groupChatService.getAllGroupChat();
  }

  @PostMapping("groupChats")
  public GroupChat addGroupChat(@RequestBody GroupChat groupChat) {
    return groupChatService.addGroupChat(groupChat);
  }

  @PutMapping("groupChats")
  public GroupChat updateGroupChat(@RequestBody GroupChat groupChat) {
    return groupChatService.updateGroupChat(groupChat);
  }

  @DeleteMapping("groupChats")
  public void deleteGroupChat(@RequestBody GroupChat groupChat) {
     groupChatService.addGroupChat(groupChat);
     return;
  }

}
