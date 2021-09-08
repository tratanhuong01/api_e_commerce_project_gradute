package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

  @Autowired
  BrandRepository brandRepository;

  public List<Brand> getAllBrands() {
    return brandRepository.findAll();
  }

  public Optional<Brand> getBrandById(String idBrand) {
    return brandRepository.findById(idBrand);
  }

  public Brand addBrand(Brand brand) {
    return brandRepository.save(brand);
  }

  public List<Brand> getBrandsLimit(int offset,int limit) {
    return brandRepository.getBrandsLimit(offset, limit);
  }

  public List<Brand> getBrandBySlugGroupProduct(String slugGroupProduct) {
    List<String> stringList = brandRepository.getBrandBySlugGroupProduct(slugGroupProduct);
    List<Brand> brandList = new ArrayList<>();
    for (String string: stringList)
      brandList.add(brandRepository.getBrandByIdBrand(string));
    return brandList;
  }

}
