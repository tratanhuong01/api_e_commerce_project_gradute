package com.api.api_e_commerce_project_gradute.discount_code;

import com.api.api_e_commerce_project_gradute.DTO.specification.discount_code.DiscountCodeCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.discount_code.DiscountCodeSpecification;
import com.api.api_e_commerce_project_gradute.discount_code_user.DiscountCodeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class DiscountCodeService {

  @Autowired
  DiscountCodeRepository discountCodeRepository;

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

  public DiscountCode checkUserIsUsed(String code,String idUser,int isUsed) {
    return discountCodeRepository.checkUserIsUsed(code, idUser,isUsed);
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

}
