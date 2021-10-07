package com.api.api_e_commerce_project_gradute.config_website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigWebsiteRepository extends JpaRepository<ConfigWebsite,Long> {

  @Query(value = "SELECT * FROM config_website ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<ConfigWebsite> getConfigWebsiteLimit(int offset, int limit);

  @Query(value = "SELECT * FROM config_website WHERE type = ?1 ",nativeQuery = true)
  ConfigWebsite getConfigWebsiteByType(int type);

}
