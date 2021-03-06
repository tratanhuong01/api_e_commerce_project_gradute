package com.api.api_e_commerce_project_gradute.discount_code;

import com.api.api_e_commerce_project_gradute.DTO.specification.discount_code.DiscountCodeCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.discount_code.DiscountCodeSpecification;
import com.api.api_e_commerce_project_gradute.discount_code_user.DiscountCodeUser;
import com.api.api_e_commerce_project_gradute.user.User;
import com.api.api_e_commerce_project_gradute.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DiscountCodeService {

  @Autowired
  DiscountCodeRepository discountCodeRepository;

  @Autowired
  UserRepository userRepository;

  public List<DiscountCode> getDiscountCodes() {
    return discountCodeRepository.findAll();
  }

  public DiscountCode addDiscountCode(DiscountCode discountCode) {
    discountCode.setTimeCreated(new Timestamp(new Date().getTime()));
    return discountCodeRepository.save(discountCode);
  }

  public DiscountCode updateDiscountCode(DiscountCode discountCode) {
    return discountCodeRepository.save(discountCode);
  }

  public DiscountCode checkDiscountCodeValid(String code) {
    return discountCodeRepository.checkDiscountCodeIsValid(code);
  }

  public DiscountCode checkUserIsUsed(String code,String idUser) {
    return discountCodeRepository.checkUserIsUsed(code, idUser);
  }

  public DiscountCode checkDiscountCodeStillExpired(String code) {
    return discountCodeRepository.checkDiscountCodeStillExpired(code);
  }

  public void deleteDiscountCode(DiscountCode discountCode) {
    discountCodeRepository.delete(discountCode);
  }

  public Integer filterDiscountCodeAll(DiscountCodeCriteria discountCodeCriteria) {
    Specification<DiscountCode> discountCodeSpecification = DiscountCodeSpecification.createDiscountCodeSpecification(
        discountCodeCriteria
    );
    return discountCodeRepository.findAll(discountCodeSpecification).size();
  }

  public List<DiscountCode> filterDiscountCodeLimit(DiscountCodeCriteria discountCodeCriteria) {
    Specification<DiscountCode> discountCodeSpecification = DiscountCodeSpecification.createDiscountCodeSpecification(
        discountCodeCriteria
    );
    Pageable pageable = PageRequest.of(discountCodeCriteria.getOffset(),discountCodeCriteria.getLimit());
    Page<DiscountCode> discountCodePage = discountCodeRepository.findAll(discountCodeSpecification,pageable);
    return discountCodePage.getContent();
  }

  public List<User> checkAllVoucherValid(Integer amount) {
    Integer length = userRepository.getCustomerRegister();
    List<User> userList = null;
    if (amount <= length) {
      List<UserVoucher> userVoucherList = userRepository.getUserBuyMost(amount);
      userList = new ArrayList<>();
      for (UserVoucher userVoucher : userVoucherList) {
        userList.add(userRepository.getUserByIdUser(userVoucher.getIdUser()));
      }
    }
    return userList;
  }

}
