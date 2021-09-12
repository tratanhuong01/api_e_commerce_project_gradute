package com.api.api_e_commerce_project_gradute.discount_code_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeUserService {

  @Autowired
  DiscountCodeUserRepository discountCodeUserRepository;

  public List<DiscountCodeUser> getDiscountCodeUserByIdUser(String idUser,int isUsed,int type) {
    if (type == 0)
      return discountCodeUserRepository.getDiscountCodeUserByIdUser(idUser, isUsed);
    else if (type == 2)
      return discountCodeUserRepository.getDiscountCodeUserNearExpired(idUser,isUsed);
    else
      return discountCodeUserRepository.getDiscountCodeUserExpired(idUser);
  }

  public DiscountCodeUser addDiscountCodeUser(DiscountCodeUser discountCodeUser) {
    return discountCodeUserRepository.save(discountCodeUser);
  }

  public DiscountCodeUser checkDiscountCodeUserHave(Long idDiscountCode,String idUser) {
    return discountCodeUserRepository.checkDiscountCodeUserHave(idDiscountCode, idUser);
  }

}
