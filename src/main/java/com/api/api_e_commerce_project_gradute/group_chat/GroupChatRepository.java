package com.api.api_e_commerce_project_gradute.group_chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupChatRepository extends JpaRepository<GroupChat,Long> {

  @Query(value = "SELECT * FROM group_chat WHERE id = ?1 ",nativeQuery = true)
  GroupChat getGroupChatByIdGroupChat(Long idGroupChat);

}
