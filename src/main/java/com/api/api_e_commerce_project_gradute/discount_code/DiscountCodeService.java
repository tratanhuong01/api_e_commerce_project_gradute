package com.api.api_e_commerce_project_gradute.discount_code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeService {

  @Autowired
  DiscountCodeRepository discountCodeRepository;

  public List<DiscountCode> getDiscountCodes() {
    return discountCodeRepository.findAll();
  }

  public DiscountCode addDiscountCode(DiscountCode discountCode) {
    return discountCodeRepository.save(discountCode);
  }

}
