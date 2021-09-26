package com.api.api_e_commerce_project_gradute.DTO.specification.news;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class NewsCriteria {

  private String category;
  private String commentSorter;
  private String viewSorter;
  private String poster;
  private Integer offset;
  private Integer limit;
  private String keyword;

}
