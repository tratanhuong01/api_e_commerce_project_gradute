package com.api.api_e_commerce_project_gradute.discount_code_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DiscountCodeUserController {

  @Autowired
  DiscountCodeUserService discountCodeUserService;

  @GetMapping("discountCodeUsers")
  public List<DiscountCodeUser> getDiscountCodeUsers(@RequestParam(required = false) String idUser,
                                                     @RequestParam(required = false) int isUsed,
                                                     @RequestParam(required = false) int type) {
    return discountCodeUserService.getDiscountCodeUserByIdUser(idUser, isUsed,type);
  }

  @PostMapping("discountCodeUsers")
  public DiscountCodeUser addDiscountCodeUser(@RequestBody DiscountCodeUser discountCodeUser) {
    return discountCodeUserService.addDiscountCodeUser(discountCodeUser);
  }

  @GetMapping("discountCodeUsers/{idDiscountCode}/{idUser}")
  public DiscountCodeUser checkDiscountCodeUserHave(@PathVariable Long idDiscountCode,@PathVariable String idUser) {
    return discountCodeUserService.checkDiscountCodeUserHave(idDiscountCode, idUser);
  }

  @GetMapping("discountCodeUsers/update/isUsed/")
  public int updateDiscountCodeUser(@RequestParam(required = false) int isUsed,@RequestParam(required = false) String idUser,
                                    @RequestParam(required = false) Long idDiscountCode) {
    return discountCodeUserService.updateDiscountCode(idUser,idDiscountCode,isUsed);
  }

}
