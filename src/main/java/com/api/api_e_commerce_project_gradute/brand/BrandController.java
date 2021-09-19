package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class BrandController {

  @Autowired
  BrandService brandService;

  @GetMapping("brandsAll")
  public List<Brand> getAll() {
    return brandService.getAllBrands();
  }

  @GetMapping("brands")
  public List<Brand> getAllBrands() {
    return brandService.getBrandsLimit(0,10);
  }

  @GetMapping("brands/{offset}/{limit}")
  public List<Brand> getBrandsLimit(@PathVariable int offset,@PathVariable int limit) {
    return brandService.getBrandsLimit(offset,limit);
  }

  @GetMapping("brands/{idBrand}")
  public Optional<Brand> getBrandById(@PathVariable String idBrand) {
    return brandService.getBrandById(idBrand);
  }

  @PostMapping("brands")
  public Brand addBrand(@RequestBody Brand brand) {
    return brandService.addBrand(brand);
  }

  @PutMapping("brands")
  public Brand updateBrand(@RequestBody Brand brand) {
    return brandService.addBrand(brand);
  }

  @GetMapping("brands/slugGroupProduct/{slugGroupProduct}")
  public List<Brand> getBrandBySlugGroupProduct(@PathVariable String slugGroupProduct) {
    return brandService.getBrandBySlugGroupProduct(slugGroupProduct);
  }

}
