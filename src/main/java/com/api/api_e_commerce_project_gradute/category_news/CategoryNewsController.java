package com.api.api_e_commerce_project_gradute.category_news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryNewsController {

  @Autowired
  CategoryNewsService categoryNewsService;

  @CrossOrigin
  @GetMapping("categoryNews")
  public List<CategoryNews> getAllCategoryNews() {
    return categoryNewsService.getAllCategoryNews();
  }

  @CrossOrigin
  @GetMapping("categoryNews/{idCategoryNews}")
  public CategoryNews getCategoryNewsById(@PathVariable Long idCategoryNews) {
    return categoryNewsService.getCategoryNewsById(idCategoryNews);
  }

  @CrossOrigin
  @PostMapping("categoryNews")
  public CategoryNews addCategoryNews(@RequestBody CategoryNews categoryNews) {
    return categoryNewsService.addCategoryNews(categoryNews);
  }

  @CrossOrigin
  @PutMapping("categoryNews")
  public CategoryNews updateCategoryNews(@RequestBody CategoryNews categoryNews) {
    return categoryNewsService.addCategoryNews(categoryNews);
  }

}
