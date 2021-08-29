package com.api.api_e_commerce_project_gradute.slide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public List<Slide> addSlide(Slide slide) {
    slideRepository.save(slide);
    return slideRepository.findAll();
  }

}
