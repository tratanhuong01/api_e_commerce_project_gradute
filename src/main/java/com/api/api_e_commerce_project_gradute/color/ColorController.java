package com.api.api_e_commerce_project_gradute.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ColorController {

  @Autowired
  ColorService colorService;

  // admin

  @GetMapping("colorsAll/search/")
  public List<Color> searchColorAll(@RequestParam(required = false) String keyword) {
    return colorService.searchColorAll(keyword);
  }

  @GetMapping("colors/search/")
  public List<Color> searchColorLimit(@RequestParam(required = false) String keyword, @RequestParam(required = false) int offset,
                                      @RequestParam(required = false) int limit) {
    return colorService.searchColorLimit(keyword,offset,limit);
  }

  @DeleteMapping("colors")
  public void deleteColor(@RequestBody Color color) {
    colorService.deleteColor(color);
  }

  // user

  @GetMapping("colorsAll")
  public List<Color> getAll() {
    return colorService.getAllColors();
  }

  @GetMapping("colors")
  public List<Color> getAllColors() {
    return colorService.getColorsLimit(0,10);
  }

  @GetMapping("colors/{offset}/{limit}")
  public List<Color> getColorsLimit(@PathVariable int offset,@PathVariable int limit) {
    return colorService.getColorsLimit(offset,limit);
  }

  @GetMapping("colors/{idColor}")
  public Optional<Color> getColorById(@PathVariable String idColor) {
    return colorService.getColorById(idColor);
  }

  @PostMapping("colors")
  public Color addColor(@RequestBody Color color) {
    return colorService.addColor(color);
  }

  @PutMapping("colors")
  public Color updateColor(@RequestBody Color color) {
    return colorService.addColor(color);
  }

}
