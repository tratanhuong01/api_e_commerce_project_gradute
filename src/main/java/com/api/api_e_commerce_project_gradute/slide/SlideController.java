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
  public List<Slide> getSlideLimit() {
    return slideService.getAllSlideAllLimit(0,10);
  }

  @GetMapping("getSlidesActive")
  public List<Slide> getAllSlideLimit() {
    return slideService.getAllSlideLimit(0,3);
  }

  @GetMapping("slides/{offset}/{limit}")
  public List<Slide> getAllSlideAllLimit(@PathVariable int offset,@PathVariable int limit) {
    return slideService.getAllSlideAllLimit(offset, limit);
  }

  @PostMapping("slides")
  public List<Slide> addSlide(@RequestBody Slide slide) {
    return slideService.addSlide(slide);
  }

  @PutMapping("slides")
  public List<Slide> updateSlide(@RequestBody Slide slide) {
    return slideService.updateSlide(slide);
  }

  @DeleteMapping("slides")
  public void deleteSlide(@RequestBody Slide slide) {
     slideService.deleteSlide(slide);
  }

}
