package com.api.api_e_commerce_project_gradute.DTO.specification.discount_code;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class DiscountCodeCriteria {

  private Integer typeDiscountCode;
  private String keyword;
  private String expired;
  private String newBestSorter;
  private String percentSorter;
  private String maxSorter;
  private String minSorter;
  private Integer offset;
  private Integer limit;
  private String timeCreatedFrom;
  private String timeCreatedTo;

}
