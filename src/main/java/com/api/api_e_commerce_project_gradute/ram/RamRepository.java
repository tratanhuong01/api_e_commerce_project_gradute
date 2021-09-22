package com.api.api_e_commerce_project_gradute.ram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RamRepository extends JpaRepository<Ram,String> {

  @Query(value = "SELECT * FROM ram WHERE id = ?1 ",nativeQuery = true)
  Ram getRamByIdRam(Long id);

  @Query(value = "SELECT * FROM ram ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Ram> getRamLimit(int offset,int limit);

  @Query(value = "SELECT * FROM ram WHERE id = :keyword OR name_ram LIKE CONCAT('%',:keyword,'%') LIMIT :offset , :limit "
      ,nativeQuery = true)
  List<Ram> searchRamLimit(@Param("keyword") String keyword, @Param("offset") int offset,
                                 @Param("limit") int limit);

  @Query(value = "SELECT * FROM ram WHERE id = :keyword OR name_ram LIKE CONCAT('%',:keyword,'%')  ",
      nativeQuery = true)
  List<Ram> searchRamAll(@Param("keyword") String keyword);

}
