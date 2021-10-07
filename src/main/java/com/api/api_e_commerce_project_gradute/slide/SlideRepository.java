package com.api.api_e_commerce_project_gradute.slide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlideRepository extends JpaRepository<Slide,Long> {

  @Query(value = "SELECT * FROM slide WHERE type = 0 ORDER BY time_created DESC LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Slide> getAllSlideLimit(int offset, int limit);

  @Query(value = "SELECT * FROM slide ORDER BY time_created DESC  LIMIT ?1 , ?2 ",nativeQuery = true)
  List<Slide> getAllSlideLimitNews(int offset, int limit);

}
