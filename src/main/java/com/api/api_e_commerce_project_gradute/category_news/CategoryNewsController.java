package com.api.api_e_commerce_project_gradute.category_news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class CategoryNewsController {

  @Autowired
  CategoryNewsService categoryNewsService;

  @GetMapping("categoryNews")
  public List<CategoryNews> getAllCategoryNews() {
    return categoryNewsService.getAllCategoryNews();
  }

  @GetMapping("categoryNews/{idCategoryNews}")
  public Optional<CategoryNews> getCategoryNewsById(@PathVariable Long idCategoryNews) {
    return categoryNewsService.getCategoryNewsById(idCategoryNews);
  }

  @PostMapping("categoryNews")
  public CategoryNews addCategoryNews(@RequestBody CategoryNews categoryNews) {
    return categoryNewsService.addCategoryNews(categoryNews);
  }

  @PutMapping("categoryNews")
  public CategoryNews updateCategoryNews(@RequestBody CategoryNews categoryNews) {
    return categoryNewsService.addCategoryNews(categoryNews);
  }

}
