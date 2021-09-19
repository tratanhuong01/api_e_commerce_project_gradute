package com.api.api_e_commerce_project_gradute.discount_code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DiscountCodeController {

  @Autowired
  DiscountCodeService discountCodeService;

  @GetMapping("discountCodes")
  public List<DiscountCode> getDiscountCodes() {
    return discountCodeService.getDiscountCodes();
  }

  @PostMapping("discountCodes")
  public DiscountCode addDiscountCode(@RequestBody DiscountCode discountCode) {
    return discountCodeService.addDiscountCode(discountCode);
  }

  @GetMapping("discountCodes/check/isUsed/")
  public DiscountCode checkUserIsUsed(@RequestParam(required = false) String code,
                                      @RequestParam(required = false) String idUser,
                                      @RequestParam(required = false) int isUsed) {
    return discountCodeService.checkUserIsUsed(code,idUser,isUsed);
  }

  @GetMapping("discountCodes/check/valid/")
  public DiscountCode checkDiscountCodeIsValid(@RequestParam(required = false) String code) {
    return discountCodeService.checkDiscountCodeValid(code);
  }

  @GetMapping("discountCodes/check/expired/")
  public DiscountCode checkDiscountCodeStillExpired(@RequestParam(required = false) String code) {
    return discountCodeService.checkDiscountCodeStillExpired(code);
  }

}
