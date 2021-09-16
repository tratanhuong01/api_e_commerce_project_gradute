package com.api.api_e_commerce_project_gradute.info_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface InfoProductRepository extends JpaRepository<InfoProduct,Long> {

  @Query(value = "SELECT item_current FROM info_product WHERE id_product = ?1 ",nativeQuery = true)
  int getItemCurrentProductById(String idProduct);

  @Transactional
  @Modifying
  @Query(value = "UPDATE info_product SET item_current = item_current - ?1 , item_sold = item_sold + ?1" +
      " WHERE id_product = ?2",nativeQuery = true)
  int updateItemProductCurrentAndBold(int amount,String idProduct);

}
