package com.api.api_e_commerce_project_gradute.slide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SlideService {

  @Autowired
  SlideRepository slideRepository;

  public List<Slide> getAllSlides() {
    return slideRepository.findAll();
  }

  public List<Slide> getAllSlideLimit(int offset,int limit) {
    return slideRepository.getAllSlideLimit(offset, limit);
  }

  public List<Slide> getAllSlideAllLimit(int offset,int limit) {
    return slideRepository.getAllSlideLimitNews(offset, limit);
  }

  public List<Slide> addSlide(Slide slide) {
    slide.setTimeCreated(new Timestamp(new Date().getTime()));
    slideRepository.save(slide);
    return slideRepository.findAll();
  }

  public List<Slide> updateSlide(Slide slide) {
    slideRepository.save(slide);
    return slideRepository.findAll();
  }

  public void deleteSlide(Slide slide) {
    slideRepository.delete(slide);
  }

}
