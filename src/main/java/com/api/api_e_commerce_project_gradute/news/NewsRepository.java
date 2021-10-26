package com.api.api_e_commerce_project_gradute.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {

  List<News> findAll(@Nullable Specification<News> newsSpecification);

  Page<News> findAll(@Nullable Specification<News> newsSpecification, Pageable pageable);

  Page<News> findAll(@Nullable Pageable pageable);

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

  @Query(value = "SELECT * FROM news WHERE id_category_news = ?1 AND id != ?2 ORDER BY time_created DESC LIMIT 0 , 4  ",nativeQuery = true)
  List<News> getListNewsSame(String idCategoryNews,Long id);

  @Query(value = "SELECT * FROM news ORDER BY view DESC LIMIT 0 , 4",nativeQuery = true)
  List<News> getListNewsMostView();

  @Query(value = "SELECT COUNT(*) FROM news ORDER BY time_created DESC ",nativeQuery = true)
  int getNumberNews();

  @Query(value = "SELECT * FROM news ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<News> getListAllNewsBestLimit(int offset,int limit);

  @Query(value = "SELECT * FROM news WHERE id_category_news = ?1 ORDER BY time_created LIMIT ?2 , ?3 ",nativeQuery = true)
  List<News> getListNewsByCategoryLimit(String idCategoryNews,int offset,int limit);

  @Query(value = "SELECT * FROM news WHERE id_category_news = ?1 ORDER BY time_created ",nativeQuery = true)
  List<News> getListNewsByCategoryAll(String idCategoryNews);

  @Query(value = "SELECT * FROM news ORDER BY time_created LIMIT ?1 , ?2 ",nativeQuery = true)
  List<News> getNewsLimit(int offset,int limit);

  @Query(value = "SELECT * FROM news WHERE id_category_news = ?1 ORDER BY time_created DESC LIMIT 0,6 ",nativeQuery = true)
  List<News> getNewsByIdCategory(String idCategoryNews);

}
