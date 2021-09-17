package com.api.api_e_commerce_project_gradute.messages;

import com.api.api_e_commerce_project_gradute.DTO.messages.MessagesCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class MessagesController {

  @Autowired
  MessagesService messagesService;

  @GetMapping("messages")
  public List<Messages> getAllMessages() {
    return messagesService.getAllMessages();
  }

  @PostMapping("messages")
  public Messages addMessages(@RequestBody Messages messages) {
    return messagesService.addMessages(messages);
  }

  @PutMapping("messages")
  public Messages updateMessages(@RequestBody Messages messages) {
    return messagesService.addMessages(messages);
  }

  @DeleteMapping("messages")
  public void deleteMessages(@RequestBody Messages messages) {
    messagesService.deleteMessages(messages);
    return;
  }

  @GetMapping("messages/{idUser}")
  public List<MessagesCustom> getMessageByIdUser(@PathVariable String idUser) {
    return messagesService.getMessagesByIdUser(idUser);
  }

  @GetMapping("messages/group/{id}")
  public MessagesCustom getMessageByIdGroupChat(@PathVariable Long id) {
    return messagesService.getMessageByIdGroupChat(id);
  }

}
