package com.api.api_e_commerce_project_gradute.discount_code_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeUserService {

  @Autowired
  DiscountCodeUserRepository discountCodeUserRepository;

  public List<DiscountCodeUser> getAllDiscountCodeUsers() {
    return discountCodeUserRepository.findAll();
  }

  public DiscountCodeUser addDiscountCodeUser(DiscountCodeUser discountCodeUser) {
    return discountCodeUserRepository.save(discountCodeUser);
  }

}
