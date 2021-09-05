package com.api.api_e_commerce_project_gradute.memory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<Memory,String> {

  @Query(value = "SELECT * FROM memory WHERE id = ?1 ",nativeQuery = true)
  Memory getMemoryByIdMemory(Long idMemory);

  @Query(value = "SELECT * FROM memory LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Memory> getMemoriesLimit(int offset,int limit);

}
