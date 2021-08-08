package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

  @Autowired
  BrandService brandService;

  @CrossOrigin
  @GetMapping("brands")
  public List<Brand> getAllBrands() {
    return brandService.getAllBrands();
  }

  @CrossOrigin
  @GetMapping("brands/{idBrand}")
  public Brand getBrandById(@PathVariable String idBrand) {
    return brandService.getBrandById(idBrand);
  }

  @CrossOrigin
  @PostMapping("brands")
  public Brand addBrand(@RequestBody Brand brand) {
    return brandService.addBrand(brand);
  }

  @CrossOrigin
  @PutMapping("brands")
  public Brand updateBrand(@RequestBody Brand brand) {
    return brandService.addBrand(brand);
  }

}
