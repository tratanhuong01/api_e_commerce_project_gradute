package com.api.api_e_commerce_project_gradute.wish_list;

import com.api.api_e_commerce_project_gradute.DTO.cart.CartFull;
import com.api.api_e_commerce_project_gradute.DTO.cart.CartMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

  @Query(value = "SELECT * FROM wish_list WHERE id_user = ?1 ",nativeQuery = true)
  List<WishList> getWishListByIdUser(String id);

  @Query(value = "SELECT wl.id as 'idCart' , p.id as 'idProduct' , u.id as 'idUser' , u.first_name as 'firstName' , " +
      " u.last_name as 'lastName' , lp.id as  'idLineProduct' , " +
      " lp.name_line_product as 'nameLineProduct' , pi.price_input as 'priceInput' ," +
      " po.price_output as 'priceOutput' , s.percent as 'sale' ,c.id as 'color', m.id as " +
      " 'memory' , i.id as 'image' ,p.slug as 'slug' , " +
      "  b.name_brand as 'brand' , wl.amount as 'amount' FROM wish_list wl " +
      " INNER JOIN product p ON wl.id_product = p.id " +
      " INNER JOIN user u ON wl.id_user = u.id " +
      " INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      " INNER JOIN group_product gp ON lp.id_group_product = gp.id" +
      " INNER JOIN category_product cp ON gp.id_category_product = cp.id" +
      " LEFT JOIN color c ON p.id_color = c.id " +
      " LEFT JOIN memory m ON p.id_memory = m.id" +
      " LEFT JOIN sale s ON s.id_product = p.id" +
      " LEFT JOIN product_output po ON po.id_product = p.id  " +
      " LEFT JOIN product_input pi ON pi.id_product = p.id" +
      " INNER JOIN brand b ON p.id_brand = b.id " +
      " INNER JOIN image i ON p.id_image = i.id " +
      " WHERE wl.id_user = ?1 ",nativeQuery = true)
  List<CartMain> getAllWishListByIdUser(String idUser);

  @Query(value = "SELECT * FROM wish_list WHERE id_user = ?1 AND id_product = ?2 ",nativeQuery = true)
  WishList checkWishList(String idUser,String idProduct);

}
