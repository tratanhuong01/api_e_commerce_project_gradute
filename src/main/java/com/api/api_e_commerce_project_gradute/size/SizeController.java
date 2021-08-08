package com.api.api_e_commerce_project_gradute.size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SizeController {

  @Autowired
  SizeService sizeService;

  @CrossOrigin
  @GetMapping("sizes")
  public List<Size> getAllSizes() {
    return sizeService.getAllSizes();
  }

  @CrossOrigin
  @GetMapping("sizes/{idSize}")
  public Size getSizeById(@PathVariable String idSize) {
    return sizeService.getSizeById(idSize);
  }

  @CrossOrigin
  @PostMapping("sizes")
  public Size addSize(@RequestBody Size size) {
    return sizeService.addSize(size);
  }

  @CrossOrigin
  @PutMapping("sizes")
  public Size updateSize(@RequestBody Size size) {
    return sizeService.addSize(size);
  }

}
