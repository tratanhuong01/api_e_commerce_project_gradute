package com.api.api_e_commerce_project_gradute.category_news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryNewsService {

  @Autowired
  CategoryNewsRepository categoryNewsRepository;

  public List<CategoryNews> getAllCategoryNews() {
    return categoryNewsRepository.findAll();
  }

  public Optional<CategoryNews> getCategoryNewsById(Long idCategoryNews) {
    return categoryNewsRepository.findById(idCategoryNews);
  }

  public CategoryNews addCategoryNews(CategoryNews categoryNews) {
    return categoryNewsRepository.save(categoryNews);
  }

}
