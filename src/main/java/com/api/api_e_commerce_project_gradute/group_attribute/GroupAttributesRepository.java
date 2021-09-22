package com.api.api_e_commerce_project_gradute.group_attribute;

import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAttributesRepository extends JpaRepository<GroupAttribute,String> {

  @Query(value = "SELECT * FROM group_attribute ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<GroupAttribute> getAllGroupAttributeLimit(int offset, int limit);

  @Query(value = "SELECT * FROM group_attribute WHERE id = ?1 ",nativeQuery = true)
  GroupAttribute getGroupAttributeById(String id);

  @Query(value = "SELECT * FROM group_attribute WHERE id = :keyword OR name_group_attribute LIKE CONCAT('%',:keyword,'%') " +
      "LIMIT :offset , :limit ",nativeQuery = true)
  List<GroupAttribute> searchGroupAttributeLimit(@Param("keyword") String keyword, @Param("offset") int offset,
                                                   @Param("limit") int limit);

  @Query(value = "SELECT * FROM group_attribute WHERE id = :keyword OR name_group_attribute LIKE CONCAT('%',:keyword,'%') ",
      nativeQuery = true)
  List<GroupAttribute> searchGroupAttributeAll(@Param("keyword") String keyword);

}
