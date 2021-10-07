package com.api.api_e_commerce_project_gradute.banner_index;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BannerIndexRepository extends JpaRepository<BannerIndex,Long> {

  @Query(value = "SELECT * FROM banner_index ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<BannerIndex> getBannerIndexLimit(int offset,int limit);

}
