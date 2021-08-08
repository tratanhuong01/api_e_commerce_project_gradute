package com.api.api_e_commerce_project_gradute.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

  @Autowired
  BrandRepository brandRepository;

  public List<Brand> getAllBrands() {
    return brandRepository.findAll();
  }

  public Brand getBrandById(String idBrand) {
    return brandRepository.getById(idBrand);
  }

  public Brand addBrand(Brand brand) {
    return brandRepository.save(brand);
  }

}
