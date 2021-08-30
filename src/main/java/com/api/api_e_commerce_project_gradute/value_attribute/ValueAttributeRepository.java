package com.api.api_e_commerce_project_gradute.value_attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValueAttributeRepository extends JpaRepository<ValueAttribute,Long> {

  @Query(value = "SELECT * FROM value_attribute LIMIT ?1 , ?2 ",nativeQuery = true)
  List<ValueAttribute> getAllValueAttributeLimit(int offset,int limit);

}
