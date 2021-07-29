package com.api.api_e_commerce_project_gradute.news_detail;

import com.api.api_e_commerce_project_gradute.news_detail.NewsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDetailRepository extends JpaRepository<NewsDetail,Long> {

}
