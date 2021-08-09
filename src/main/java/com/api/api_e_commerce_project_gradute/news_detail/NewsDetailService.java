package com.api.api_e_commerce_project_gradute.news_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsDetailService {

  @Autowired
  NewsDetailRepository newsDetailRepository;

  public List<NewsDetail> getAllNewsDetails() {
    return newsDetailRepository.findAll();
  }

  public Optional<NewsDetail> getNewsDetailById(Long idNewsDetail) {
    return newsDetailRepository.findById(idNewsDetail);
  }

  public NewsDetail addNewsDetail(NewsDetail newsDetail) {
    return newsDetailRepository.save(newsDetail);
  }

}
