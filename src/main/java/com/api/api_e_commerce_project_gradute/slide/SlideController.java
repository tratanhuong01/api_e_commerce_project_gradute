package com.api.api_e_commerce_project_gradute.slide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class SlideController {

  @Autowired
  SlideService slideService;

  @GetMapping("slidesAll")
  public List<Slide> getAllSlide() {
    return slideService.getAllSlides();
  }

  @GetMapping("slides")
  public List<Slide> getAllSlideLimit() {
    return slideService.getAllSlideLimit(0,3);
  }

  @PostMapping("slides")
  public List<Slide> addSlide(@RequestBody Slide slide) {
    return slideService.addSlide(slide);
  }

}
