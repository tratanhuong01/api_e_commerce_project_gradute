package com.api.api_e_commerce_project_gradute.category_news;

import com.api.api_e_commerce_project_gradute.category_news.CategoryNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryNewsRepository extends JpaRepository<CategoryNews,Long> {
}
