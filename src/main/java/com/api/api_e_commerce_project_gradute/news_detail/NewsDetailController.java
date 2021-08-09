package com.api.api_e_commerce_project_gradute.news_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewsDetailController {

  @Autowired
  NewsDetailService newsDetailService;

  @CrossOrigin
  @GetMapping("newsDetails")
  public List<NewsDetail> getAllNewsDetails() {
    return newsDetailService.getAllNewsDetails();
  }

  @CrossOrigin
  @GetMapping("newsDetails/{idNewsDetail}")
  public Optional<NewsDetail> getNewsDetailById(@PathVariable Long idNewsDetail) {
    return newsDetailService.getNewsDetailById(idNewsDetail);
  }

  @CrossOrigin
  @PostMapping("newsDetails")
  public NewsDetail addNewsDetail(@RequestBody NewsDetail newsDetail) {
    return newsDetailService.addNewsDetail(newsDetail);
  }

  @CrossOrigin
  @PutMapping("newsDetails")
  public NewsDetail updateNewsDetail(@RequestBody NewsDetail newsDetail) {
    return newsDetailService.addNewsDetail(newsDetail);
  }

}
