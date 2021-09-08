package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BrandController {

  @Autowired
  BrandService brandService;

  @CrossOrigin
  @GetMapping("brandsAll")
  public List<Brand> getAll() {
    return brandService.getAllBrands();
  }

  @CrossOrigin
  @GetMapping("brands")
  public List<Brand> getAllBrands() {
    return brandService.getBrandsLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("brands/{offset}/{limit}")
  public List<Brand> getBrandsLimit(@PathVariable int offset,@PathVariable int limit) {
    return brandService.getBrandsLimit(offset,limit);
  }

  @CrossOrigin
  @GetMapping("brands/{idBrand}")
  public Optional<Brand> getBrandById(@PathVariable String idBrand) {
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

  @CrossOrigin
  @GetMapping("brands/slugGroupProduct/{slugGroupProduct}")
  public List<Brand> getBrandBySlugGroupProduct(@PathVariable String slugGroupProduct) {
    return brandService.getBrandBySlugGroupProduct(slugGroupProduct);
  }

}
