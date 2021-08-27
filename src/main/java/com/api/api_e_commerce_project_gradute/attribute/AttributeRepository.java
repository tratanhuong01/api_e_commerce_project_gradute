package com.api.api_e_commerce_project_gradute.attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute,String> {

  @Query(value = "SELECT * FROM attribute LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Attribute> getAllAttributeLimit(int offset,int limit);

  @Query(value = "SELECT * FROM attribute WHERE id_group_attribute = ?1 ",nativeQuery = true)
  List<Attribute> getAttributeByIdGroupAttribute(String id);

}
