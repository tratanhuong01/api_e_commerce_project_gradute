package com.api.api_e_commerce_project_gradute.DTO.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
public class ProductCriteria {

  private Set<String> brand;
  private Set<Long> ram;
  private Set<Long> rom;
  private Set<Long> color;
  private Set<Long> feature;
  private Integer priceTo;
  private Integer priceFrom;
  private String slugGroupProduct;
  private String filter;

}
