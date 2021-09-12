package com.api.api_e_commerce_project_gradute.discount_code;

import com.api.api_e_commerce_project_gradute.discount_code_user.DiscountCodeUser;
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

  public DiscountCode checkDiscountCodeValid(String code) {
    return discountCodeRepository.checkDiscountCodeIsValid(code);
  }

  public DiscountCode checkUserIsUsed(String code,String idUser,int isUsed) {
    return discountCodeRepository.checkUserIsUsed(code, idUser,isUsed);
  }

  public DiscountCode checkDiscountCodeStillExpired(String code) {
    return discountCodeRepository.checkDiscountCodeStillExpired(code);
  }

}
