package com.api.api_e_commerce_project_gradute.wish_list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

  @Query(value = "SELECT * FROM wish_list WHERE id_user = ?1 ",nativeQuery = true)
  List<WishList> getWishListByIdUser(String id);

}
