package com.api.api_e_commerce_project_gradute.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {

  @Query(value = "SELECT * FROM news ORDER BY time_created DESC LIMIT 0,4 ",nativeQuery = true)
  List<News> getBestNewsIndex();

  @Query(value = "SELECT * FROM news WHERE slug = ?1 LIMIT 0,1 ",nativeQuery = true)
  News getNewsBySlug(String slug);

  @Query(value = "SELECT * FROM news ORDER BY view DESC LIMIT 0,4",nativeQuery = true)
  List<News> getBestLoveNews();

  @Transactional
  @Modifying
  @Query(value = "UPDATE news SET view = view + 1 WHERE slug = ?1 ",nativeQuery = true)
  int updateViewNews(String slug);

}