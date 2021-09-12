package com.api.api_e_commerce_project_gradute.discount_code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountCodeController {

  @Autowired
  DiscountCodeService discountCodeService;

  @CrossOrigin
  @GetMapping("discountCodes")
  public List<DiscountCode> getDiscountCodes() {
    return discountCodeService.getDiscountCodes();
  }

  @CrossOrigin
  @PostMapping("discountCodes")
  public DiscountCode addDiscountCode(@RequestBody DiscountCode discountCode) {
    return discountCodeService.addDiscountCode(discountCode);
  }

  @CrossOrigin
  @GetMapping("discountCodes/check/valid/")
  public DiscountCode checkDiscountCodeIsValid(@RequestParam(required = false) String code) {
    return discountCodeService.checkDiscountCodeValid(code);
  }

}
