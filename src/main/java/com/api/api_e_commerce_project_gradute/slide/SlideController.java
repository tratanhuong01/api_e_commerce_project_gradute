package com.api.api_e_commerce_project_gradute.slide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SlideController {

  @Autowired
  SlideService slideService;

  @CrossOrigin
  @GetMapping("slidesAll")
  public List<Slide> getAllSlide() {
    return slideService.getAllSlides();
  }

  @CrossOrigin
  @GetMapping("slides")
  public List<Slide> getAllSlideLimit() {
    return slideService.getAllSlideLimit(0,3);
  }

  @CrossOrigin
  @PostMapping("slides")
  public List<Slide> addSlide(@RequestBody Slide slide) {
    return slideService.addSlide(slide);
  }

}
