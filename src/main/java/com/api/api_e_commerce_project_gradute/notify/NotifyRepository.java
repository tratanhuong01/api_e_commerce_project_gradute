package com.api.api_e_commerce_project_gradute.notify;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface NotifyRepository extends JpaRepository<Notify,Long> {

  @Query(value = "SELECT * FROM notify WHERE id_user = ?1 ORDER BY time_created DESC ",nativeQuery = true)
  List<Notify> getNotifyByIdUserAll(String idUser);

  @Query(value = "SELECT * FROM notify WHERE id_user = ?1 ORDER BY time_created DESC LIMIT ?2 , ?3 ",nativeQuery = true)
  List<Notify> getNotifyByIdUserLimit(String idUser,Integer offset,Integer limit);

}
