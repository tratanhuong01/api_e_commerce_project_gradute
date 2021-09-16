package com.api.api_e_commerce_project_gradute.messages;

import com.api.api_e_commerce_project_gradute.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages,Long> {

  @Query(value = "SELECT * FROM messages WHERE id_group_chat = ?1 ORDER BY time_created ASC ",nativeQuery = true)
  List<Messages> getMessageByIdGroupChat(Long idGroupChat);

  @Query(value = "SELECT * FROM messages WHERE id = ?1 ",nativeQuery = true)
  Messages getMessageByIdMessage(Long idMessages);

  @Query(value = "SELECT guest FROM messages WHERE id_user IS NULL AND messages.id_group_chat = ?1 LIMIT 0,1 ",nativeQuery = true)
  String getCustomer(Long idGroupChat);

}
