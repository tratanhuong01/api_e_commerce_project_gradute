package com.api.api_e_commerce_project_gradute.group_attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAttributesRepository extends JpaRepository<GroupAttribute,String> {

  @Query(value = "SELECT * FROM group_attribute LIMIT ?1 , ?2 ",nativeQuery = true)
  List<GroupAttribute> getAllGroupAttributeLimit(int offset, int limit);

  @Query(value = "SELECT * FROM group_attribute WHERE id = ?1 ",nativeQuery = true)
  GroupAttribute getGroupAttributeById(String id);

}
