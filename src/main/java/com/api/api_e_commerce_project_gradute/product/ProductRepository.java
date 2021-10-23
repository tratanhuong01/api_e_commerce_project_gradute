package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductMain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> , JpaSpecificationExecutor<Product> {

  public static String COLUMN_SELECT = " SELECT p.id as 'idProduct' , cp.id as 'idCategoryProduct',cp.name_category_product as " +
      "'nameCategoryProduct' , gp.id as 'idGroupProduct' , gp.name_group_product as 'nameGroupProduct' , lp.id as " +
      " 'idLineProduct' , lp.name_line_product as 'nameLineProduct' , ip.price_input as 'priceInput' , " +
      "  ip.price_output as 'priceOutput' , ip.sale as 'sale' ,c.id as 'idColor', m.id as " +
      "  'idMemory' , r.id as 'idRam' , p.is_show as 'isShow', i.id as 'idImage' ,p.slug as 'slug' , " +
      "  i.src as `image` , c.code as 'color' , m.name_memory as 'memory' , b.name_brand as 'idBrand' , " +
      "  lp.describe_product as 'describeProduct' , ip.item_current as 'itemCurrent' , ip.type_info_product as " +
      " 'typeProduct' , ip.review as 'review' , ip.item_sold as 'itemSold' FROM product p ";

  public static String JOIN_TABLE = " INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      " INNER JOIN group_product gp ON lp.id_group_product = gp.id" +
      " INNER JOIN category_product cp ON gp.id_category_product = cp.id" +
      " LEFT JOIN memory m ON p.id_memory = m.id" +
      " INNER JOIN info_product ip ON ip.id_product = p.id" +
      " INNER JOIN brand b ON lp.id_brand = b.id " +
      " INNER JOIN image i ON p.id_image = i.id " +
      " LEFT JOIN color c ON i.id_color = c.id " +
      " LEFT JOIN ram r ON p.id_ram = r.id ";


  List<Product> findAll(@Nullable Specification<Product> productSpecification);

  Page<Product> findAll(@Nullable Specification<Product> productSpecification, Pageable pageable);

  //get id new of product table
  @Query(value = "SELECT * FROM product ORDER BY id DESC LIMIT 1",nativeQuery = true)
  Product getIdBestNew();

  @Query(value = "SELECT * FROM product LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Product> getProductLimit(int offset,int limit);

  //get product by id
  @Query(value = "SELECT * FROM product WHERE id = ?1 ",nativeQuery = true)
  Product getProductById(String id);

  //get slug when product not have memory and have color
  @Query(value = "SELECT slug FROM product INNER JOIN image ON image.id = product.id_image " +
      "INNER JOIN color ON color.id = image.id_color WHERE image.id_color = ?1 AND id_memory " +
      "IS NULL AND product.id_line_product = ?2 ",nativeQuery = true)
  String getSlugByColorAndNotMemory(String idColor,String idLineProduct);

  //get slug when product have memory and have color
  @Query(value = "SELECT slug FROM product INNER JOIN image ON image.id = product.id_image " +
      "INNER JOIN color ON color.id = image.id_color WHERE image.id_color = ?1 AND product.id_memory = ?2 " +
      "AND product.id_line_product = ?3 ",nativeQuery = true)
  String getSlugByColorAndMemory(String idColor,String idMemory,String idLineProduct);

  //get slug when product have memory and not have color
  @Query(value = "SELECT slug FROM product INNER JOIN image ON image.id = product.id_image " +
      "INNER JOIN color ON color.id = image.id_color WHERE image.id_color IS NULL AND product.id_memory = ?1 " +
      "AND product.id_line_product = ?2 ",nativeQuery = true)
  String getSlugByNotColorAndMemory(String idMemory,String idLineProduct);

  //get product by id line product
  @Query(value = COLUMN_SELECT + JOIN_TABLE + " WHERE p.id_line_product = ?1 ",nativeQuery = true)
  List<ProductMain> getProductByIdLineProduct(String idLineProduct);

  //
  @Query(value = COLUMN_SELECT + JOIN_TABLE + " WHERE lp.name_line_product LIKE %:keyword% AND cp.slug_category_product " +
      "LIKE %:slug%  ",nativeQuery = true)
  List<ProductMain> searchProductPageAll(@Param("keyword") String keyword,@Param("slug") String slug);

  @Query(value = COLUMN_SELECT + JOIN_TABLE + " WHERE lp.name_line_product LIKE %:keyword% AND cp.slug_category_product " +
      "LIKE %:slug% LIMIT :offset , :limit ",nativeQuery = true)
  List<ProductMain> searchProductPageLimit(@Param("keyword") String keyword,@Param("slug") String slug,
                                           @Param("offset") Integer offset,@Param("limit") Integer limit);

  //get product by slug
  @Query(value = COLUMN_SELECT + JOIN_TABLE + " WHERE p.slug = ?1 ",nativeQuery = true)
  ProductMain getProductBySlug(String slug);

  @Query(value = COLUMN_SELECT + JOIN_TABLE + "ORDER BY ip.item_sold DESC LIMIT 0 , 1 ",nativeQuery = true)
  ProductMain getProductTopSell();

  //get product by id product
  @Query(value = COLUMN_SELECT + JOIN_TABLE + " WHERE p.id = ?1 ",nativeQuery = true)
  ProductMain getProductByIdProduct(String id);

  // get distinct id line product all
  @Query(value = "SELECT DISTINCT id_line_product FROM product ",nativeQuery = true)
  List<String> getDistinctIdLineProduct();

  // get distinct id line product by id category product
  @Query(value = "SELECT DISTINCT id_line_product FROM product p " +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id " +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id " +
      "WHERE cp.id = ?1 ",nativeQuery = true)
  List<String> getDistinctIdLineProductByIdCategory(String idCategory);

  @Query(value = "SELECT DISTINCT id_line_product FROM product p " +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id " +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id " +
      "WHERE cp.id = ?1 LIMIT ?2 , ?3  ",nativeQuery = true)
  List<String> getDistinctIdLineProductByIdCategoryLimit(String idCategory,int offset,int limit);

  //get distinct id line product by slug category product and slug group product
  @Query(value = "SELECT p.* FROM product p " +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id " +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id " +
      "WHERE cp.slug_category_product = ?1 AND gp.slug_group_product = ?2  ",nativeQuery = true)
  List<Product> getDistinctIdLineProductBySlugCategoryAndSlugGroupProduct(String slugCategory,String slugGroup);
  //get distinct id line product by slug category product
  @Query(value = "SELECT DISTINCT id_line_product FROM product p " +
      "INNER JOIN line_product lp ON p.id_line_product = lp.id " +
      "INNER JOIN group_product gp ON lp.id_group_product = gp.id " +
      "INNER JOIN category_product cp ON gp.id_category_product = cp.id " +
      "WHERE cp.slug_category_product = ?1 ",nativeQuery = true)
  List<String> getDistinctIdLineProductBySlugCategoryProduct(String slugCategory);

  @Query(value = "SELECT product.* FROM product INNER JOIN info_product ON product.id = info_product.id_product " +
//      "WHERE time_end >= CONCAT(DATE(NOW()),' 00:00:00') " +
      " ORDER BY info_product.sale DESC LIMIT 0,4",nativeQuery = true)
  List<Product> getProductSaleToday();

  @Query(value = "SELECT * FROM product INNER JOIN info_product ON product.id = info_product.id_product " +
      "ORDER BY MAX(info_product.item_sold) DESC",nativeQuery = true)
  List<Product> getProductTopSale();

  //filter customer

  @Query(value = "SELECT * FROM product INNER JOIN info_product ON product.id = info_product.id_product  " +
      "WHERE product.id_line_product = ?1 ORDER BY info_product.sale DESC LIMIT 0 , 1",nativeQuery = true)
  List<Product> getFirstProductByIdLineProduct(String idLineProduct);

  @Query(value = "SELECT * FROM product INNER JOIN info_product ON product.id = info_product.id_product  " +
      "WHERE product.id_line_product =:idLineProduct GROUP BY info_product.id_product ORDER BY MAX(info_product.review) DESC LIMIT 0 , 1",nativeQuery = true)
  List<Product> getFirstProductByIdLineProductReview(@Param("idLineProduct") String idLineProduct);

  @Query(value = "SELECT product.* FROM product INNER JOIN info_product ON product.id = info_product.id_product  " +
      "INNER JOIN image ON image.id = product.id_image INNER JOIN color ON color.id = image.id_color " +
      "WHERE product.id_line_product = :idLineProduct AND color.id IN (:idColor) AND GROUP BY info_product.id_product ORDER BY MAX(info_product.review) " +
      "DESC LIMIT 0 , 1",nativeQuery = true)
  List<Product> getFirstProductByIdLineProductReviewAndColor(@Param("idLineProduct") String idLineProduct, @Param("idColor") Set<Long> idColor);

  @Query(value = "SELECT product.* FROM product INNER JOIN info_product ON product.id = info_product.id_product  " +
      "INNER JOIN image ON image.id = product.id_image INNER JOIN color ON color.id = image.id_color " +
      "WHERE product.id_line_product = :idLineProduct AND color.id IN (:idColor) ",nativeQuery = true)
  List<Product> getFirstProductByIdLineProductColor(@Param("idLineProduct") String idLineProduct, @Param("idColor") Set<Long> idColor);


}
