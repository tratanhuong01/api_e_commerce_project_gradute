package com.api.api_e_commerce_project_gradute.news_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsDetailService {

  @Autowired
  NewsDetailRepository newsDetailRepository;

  public List<NewsDetail> getAllNewsDetails() {
    return newsDetailRepository.findAll();
  }

  public NewsDetail getNewsDetailById(Long idNewsDetail) {
    return newsDetailRepository.getById(idNewsDetail);
  }

  public NewsDetail addNewsDetail(NewsDetail newsDetail) {
    return newsDetailRepository.save(newsDetail);
  }

}
