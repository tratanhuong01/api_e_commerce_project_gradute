package com.api.api_e_commerce_project_gradute.cart;

import com.api.api_e_commerce_project_gradute.DTO.cart.CartMain;
import com.api.api_e_commerce_project_gradute.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

  @Query(value = "SELECT ca.id as 'idCart' , p.id as 'idProduct' , u.id as 'idUser' , u.first_name as 'firstName' , " +
      " u.last_name as 'lastName' , lp.id as  'idLineProduct' , " +
      " lp.name_line_product as 'nameLineProduct' , ip.price_input as 'priceInput' ," +
      " ip.price_output as 'priceOutput' , ip.sale as 'sale' ,c.id as 'color', m.id as " +
      " 'memory' , i.id as 'image' ,p.slug as 'slug' , " +
      "  b.name_brand as 'brand' , ca.amount as 'amount' FROM cart ca " +
      " INNER JOIN product p ON ca.id_product = p.id " +
      " INNER JOIN user u ON ca.id_user = u.id " +
      " INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      " INNER JOIN group_product gp ON lp.id_group_product = gp.id" +
      " INNER JOIN category_product cp ON gp.id_category_product = cp.id" +
      " LEFT JOIN memory m ON p.id_memory = m.id" +
      " INNER JOIN info_product ip ON ip.id_product = p.id" +
      " INNER JOIN brand b ON lp.id_brand = b.id " +
      " INNER JOIN image i ON p.id_image = i.id " +
      " LEFT JOIN color c ON i.id_color = c.id " +
      " WHERE ca.id_user = ?1 ",nativeQuery = true)
  List<CartMain> getAllCartByIdUser(String idUser);

  @Query(value = "SELECT * FROM cart WHERE id_user = ?1 AND id_product = ?2 ",nativeQuery = true)
  Cart checkCart(String idUser,String idProduct);

  @Modifying
  @Transactional
  @Query(value = "UPDATE cart SET amount = ?1 WHERE id = ?2", nativeQuery = true)
  int updateCart(int amount,Long idCart);

}
