package com.api.api_e_commerce_project_gradute.discount_code_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountCodeUserService {

  @Autowired
  DiscountCodeUserRepository discountCodeUserRepository;

  public List<DiscountCodeUser> getDiscountCodeUserByIdUser(String idUser,int isUsed,int type) {
    List<DiscountCodeUser> discountCodeUserList = new ArrayList<>();
    switch (type) {
      case 0 :
        discountCodeUserList = discountCodeUserRepository.getDiscountCodeUserByIdUser(idUser, isUsed);
        break;
      case 1 :
        discountCodeUserList = discountCodeUserRepository.getDiscountCodeUserExpired(idUser);
        break;
      case 2 :
        discountCodeUserList = discountCodeUserRepository.getDiscountCodeUserNearExpired(idUser,isUsed);
        break;
      case 3 :
        discountCodeUserList = discountCodeUserRepository.getDiscountCodeUserByIdUserUsed(idUser, isUsed);
        break;
      default:
        break;
    }
    return discountCodeUserList;
  }

  public DiscountCodeUser addDiscountCodeUser(DiscountCodeUser discountCodeUser) {
    return discountCodeUserRepository.save(discountCodeUser);
  }

  public DiscountCodeUser checkDiscountCodeUserHave(Long idDiscountCode,String idUser) {
    return discountCodeUserRepository.checkDiscountCodeUserHave(idDiscountCode, idUser);
  }

  public int updateDiscountCode(String idUser,Long idDiscountCode,int type) {
    return discountCodeUserRepository.updateDiscountCodeUserIsUsed(type,idDiscountCode,idUser);
  }

  public DiscountCodeUser checkDiscountCodeUserValidAdd(String code,String idUser) {
    return discountCodeUserRepository.checkDiscountCodeUserValidAdd(code,idUser);
  }

}
