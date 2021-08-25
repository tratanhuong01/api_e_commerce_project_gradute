package com.api.api_e_commerce_project_gradute.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ColorController {

  @Autowired
  ColorService colorService;

  @CrossOrigin
  @GetMapping("colorsAll")
  public List<Color> getAll() {
    return colorService.getAllColors();
  }

  @CrossOrigin
  @GetMapping("colors")
  public List<Color> getAllColors() {
    return colorService.getColorsLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("colors/{offset}/{limit}")
  public List<Color> getColorsLimit(@PathVariable int offset,@PathVariable int limit) {
    return colorService.getColorsLimit(offset,limit);
  }

  @CrossOrigin
  @GetMapping("colors/{idColor}")
  public Optional<Color> getColorById(@PathVariable String idColor) {
    return colorService.getColorById(idColor);
  }

  @CrossOrigin
  @PostMapping("colors")
  public Color addColor(@RequestBody Color color) {
    return colorService.addColor(color);
  }

  @CrossOrigin
  @PutMapping("colors")
  public Color updateColor(@RequestBody Color color) {
    return colorService.addColor(color);
  }

}
