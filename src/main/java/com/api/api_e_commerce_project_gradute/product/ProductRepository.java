package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductMain;
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

  @Query(value = "SELECT slug FROM product WHERE id_color = ?1 AND id_memory IS NULL AND id_line_product = ?2 ",nativeQuery = true)
  String getSlugByColorAndNotMemory(String idColor,String idLineProduct);

  @Query(value = "SELECT slug FROM product WHERE id_color = ?1 AND id_memory = ?2 AND id_line_product = ?3 ",nativeQuery = true)
  String getSlugByColorAndMemory(String idColor,String idMemory,String idLineProduct);

  @Query(value = "SELECT slug FROM product WHERE id_color IS NULL AND id_memory = ?1 AND id_line_product = ?2 ",nativeQuery = true)
  String getSlugByNotColorAndMemory(String idMemory,String idLineProduct);

  @Query(value = "SELECT p.id as 'idProduct' , cp.id as 'idCategoryProduct',cp.name_category_product as 'nameCategoryProduct' ," +
      " gp.id as 'idGroupProduct' , gp.name_group_product as 'nameGroupProduct' , lp.id as  'idLineProduct' , " +
      " lp.name_line_product as 'nameLineProduct' , pi.price_input as 'priceInput' ," +
      " po.price_output as 'priceOutput' , s.percent as 'sale' ,c.id as 'idColor', m.id as " +
      " 'idMemory' , p.is_show as 'isShow', i.id as 'idImage' ,p.slug as 'slug' , " +
      " i.src as `image` , c.code as 'color' , m.name_memory as 'memory' , b.name_brand as 'idBrand' , " +
      " p.describe_product as 'describeProduct' FROM product p " +
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
      " WHERE p.id_line_product = ?1 ",nativeQuery = true)
  List<ProductMain> getProductByIdLineProduct(String idLineProduct);

  @Query(value = "SELECT p.id as 'idProduct' , cp.id as 'idCategoryProduct',cp.name_category_product as 'nameCategoryProduct' ," +
      " gp.id as 'idGroupProduct' , gp.name_group_product as 'nameGroupProduct' , lp.id as  'idLineProduct' , " +
      " lp.name_line_product as 'nameLineProduct' , pi.price_input as 'priceInput' ," +
      " po.price_output as 'priceOutput' , s.percent as 'sale' ,c.id as 'idColor', m.id as " +
      " 'idMemory' , p.is_show as 'isShow', i.id as 'idImage' ,p.slug as 'slug' , " +
      " i.src as `image` , c.code as 'color' , m.name_memory as 'memory' , b.id as 'idBrand' , " +
      " p.describe_product as 'describeProduct' FROM product p " +
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
      " WHERE p.slug = ?1 ",nativeQuery = true)
  ProductMain getProductBySlug(String slug);

  @Query(value = "SELECT p.id as 'idProduct' , cp.id as 'idCategoryProduct',cp.name_category_product as 'nameCategoryProduct' ," +
      " gp.id as 'idGroupProduct' , gp.name_group_product as 'nameGroupProduct' , lp.id as  'idLineProduct' , " +
      " lp.name_line_product as 'nameLineProduct' , pi.price_input as 'priceInput' ," +
      " po.price_output as 'priceOutput' , s.percent as 'sale' ,c.id as 'idColor', m.id as " +
      " 'idMemory' , p.is_show as 'isShow', i.id as 'idImage' ,p.slug as 'slug' , " +
      " i.src as `image` , c.code as 'color' , m.name_memory as 'memory' , b.name_brand as 'idBrand' , " +
      " p.describe_product as 'describeProduct' FROM product p " +
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
      " WHERE p.id = ?1 ",nativeQuery = true)
  ProductMain getProductByIdProduct(String id);

  @Query(value = "SELECT DISTINCT id_line_product FROM product ",nativeQuery = true)
  List<String> getDistinctIdLineProduct();

  @Query(value = "SELECT DISTINCT id_line_product FROM product p " +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id " +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id " +
      "WHERE cp.id = ?1 ",nativeQuery = true)
  List<String> getDistinctIdLineProduct(String idCategory);

  @Query(value = "SELECT DISTINCT id_line_product FROM product p " +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id " +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id " +
      "WHERE cp.slug_category_product = ?1 AND gp.slug_group_product = ?2  ",nativeQuery = true)
  List<String> getDistinctIdLineProduct(String slugCategory,String slugGroup);

  @Query(value = "SELECT DISTINCT id_line_product FROM product p " +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id " +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id " +
      "WHERE cp.slug_category_product = ?1 ",nativeQuery = true)
  List<String> getDistinctIdLineProducts(String slugCategory);

  @Query(value = "SELECT p.*  FROM product p " +
      " INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      " INNER JOIN group_product gp ON lp.id_group_product = gp.id" +
      " INNER JOIN category_product cp ON gp.id_category_product = cp.id" ,nativeQuery = true)
  List<Product> getAll();

  @Query(value = "SELECT product.* FROM product INNER JOIN sale ON product.id = sale.id_product " +
      "WHERE time_end >= CONCAT(DATE(NOW()),' 00:00:00') " +
      "ORDER BY sale.percent + 0 DESC LIMIT 0,4",nativeQuery = true)
  List<Product> getProductSaleToday();

}
