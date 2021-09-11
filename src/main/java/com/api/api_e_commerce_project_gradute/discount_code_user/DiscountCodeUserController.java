package com.api.api_e_commerce_project_gradute.discount_code_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountCodeUserController {

  @Autowired
  DiscountCodeUserService discountCodeUserService;

  @CrossOrigin
  @GetMapping("discountCodeUsers")
  public List<DiscountCodeUser> getDiscountCodeUsers() {
    return discountCodeUserService.getAllDiscountCodeUsers();
  }

  @CrossOrigin
  @PostMapping("discountCodeUsers")
  public DiscountCodeUser addDiscountCodeUser(@RequestBody DiscountCodeUser discountCodeUser) {
    return discountCodeUserService.addDiscountCodeUser(discountCodeUser);
  }

}
