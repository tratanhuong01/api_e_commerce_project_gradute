package com.api.api_e_commerce_project_gradute.category_news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryNewsService {

  @Autowired
  CategoryNewsRepository categoryNewsRepository;

  public List<CategoryNews> getAllCategoryNews() {
    return categoryNewsRepository.findAll();
  }

  public CategoryNews getCategoryNewsById(Long idCategoryNews) {
    return categoryNewsRepository.getById(idCategoryNews);
  }

  public CategoryNews addCategoryNews(CategoryNews categoryNews) {
    return categoryNewsRepository.save(categoryNews);
  }

}
