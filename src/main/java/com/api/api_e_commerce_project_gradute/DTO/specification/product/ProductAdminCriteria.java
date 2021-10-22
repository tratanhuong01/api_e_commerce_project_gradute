package com.api.api_e_commerce_project_gradute.DTO.specification.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductAdminCriteria {

  private String brand;
  private Long ram;
  private Long rom;
  private Long color;
  private Integer priceTo;
  private Integer priceFrom;
  private String category;
  private String group;
  private String memory;
  private String sorter;
  private Integer typeProduct;
  private Integer offset;
  private Integer limit;
  private Integer status;
  private String priceOutputSorter;
  private String priceInputSorter;
  private String productSoldSorter;
  private String saleSorter;
  private String reviewSorter;
  private String keyword;
  private String timeCreatedFrom;
  private String timeCreatedTo;

}
