package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.ProductMain;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

  @Query(value = "SELECT * FROM product ORDER BY id DESC LIMIT 1",nativeQuery = true)
  Product getIdBestNew();

  @Query(value = "SELECT * FROM product WHERE id = ?1 ",nativeQuery = true)
  Product getProductById(String id);

  @Query(value = "SELECT p.id as 'idProduct' , cp.id as 'idCategoryProduct',cp.name_category_product as 'nameCategoryProduct' ," +
      " gp.id as 'idGroupProduct' , gp.name_group_product as 'nameGroupProduct' , lp.id as  'idLineProduct' , " +
      "lp.name_line_product as 'nameLineProduct' , pi.price_input as 'priceInput' ," +
      "po.price_output as 'priceOutput' , s.percent as 'sale' ,c.code as 'color', m.name_memory as " +
      "'memory',p.is_show as 'isShow', i.src as '' FROM product p" +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id" +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id" +
      "LEFT JOIN color c ON p.id_color = c.id " +
      "LEFT JOIN memory m ON p.id_memory = m.id" +
      "LEFT JOIN sale s ON s.id_product = p.id" +
      "LEFT JOIN product_output po ON po.id_product = p.id  " +
      "LEFT JOIN product_input pi ON pi.id_product = p.id" +
      "INNER JOIN image i ON p.id_image = i.id " +
      "WHERE p.id_line_product = ?1 ",nativeQuery = true)
  List<ProductMain> getListProduct(String idLineProduct);

}
