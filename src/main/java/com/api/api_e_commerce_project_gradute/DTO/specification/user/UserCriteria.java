package com.api.api_e_commerce_project_gradute.DTO.specification.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserCriteria {

  private Integer ageFrom;
  private Integer ageTo;
  private String sex;
  private Integer status;
  private Integer verifyPhone;
  private Integer verifyEmail;
  private String userType;
  private Integer offset;
  private Integer limit;
  private String timeRegisterSorter;
  private String ageSorter;
  private String keyword;
  private Integer isRegister;
  private String timeCreatedFrom;
  private String timeCreatedTo;
  private String typeRegister;

}
