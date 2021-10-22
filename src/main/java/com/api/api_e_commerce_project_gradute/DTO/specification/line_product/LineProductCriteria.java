package com.api.api_e_commerce_project_gradute.DTO.specification.line_product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class LineProductCriteria {

  private Integer offset;
  private Integer limit;
  private String brand;
  private String keyword;
  private String group;
  private String timeCreatedFrom;
  private String timeCreatedTo;

}
