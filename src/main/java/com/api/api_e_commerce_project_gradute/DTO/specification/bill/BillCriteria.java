package com.api.api_e_commerce_project_gradute.DTO.specification.bill;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BillCriteria {

  private Integer status;
  private String timeCompletedSorter;
  private String timeCreatedSorter;
  private String moneyOrderSorter;
  private String feeDeliverySorter;
  private Integer limit;
  private Integer offset;
  private String keyword;
  private String timeCreatedFrom;
  private String timeCreatedTo;

}
