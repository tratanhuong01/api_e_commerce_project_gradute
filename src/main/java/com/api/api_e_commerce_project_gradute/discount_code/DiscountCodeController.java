package com.api.api_e_commerce_project_gradute.discount_code;

import com.api.api_e_commerce_project_gradute.discount_code_user.DiscountCodeUser;
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
  @GetMapping("discountCodes/check/isUsed/")
  public DiscountCode checkUserIsUsed(@RequestParam(required = false) String code,
                                      @RequestParam(required = false) String idUser,
                                      @RequestParam(required = false) int isUsed) {
    return discountCodeService.checkUserIsUsed(code,idUser,isUsed);
  }

  @CrossOrigin
  @GetMapping("discountCodes/check/valid/")
  public DiscountCode checkDiscountCodeIsValid(@RequestParam(required = false) String code) {
    return discountCodeService.checkDiscountCodeValid(code);
  }

  @CrossOrigin
  @GetMapping("discountCodes/check/expired/")
  public DiscountCode checkDiscountCodeStillExpired(@RequestParam(required = false) String code) {
    return discountCodeService.checkDiscountCodeStillExpired(code);
  }

}