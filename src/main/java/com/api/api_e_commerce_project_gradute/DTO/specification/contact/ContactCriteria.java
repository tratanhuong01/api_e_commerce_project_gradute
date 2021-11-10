package com.api.api_e_commerce_project_gradute.DTO.specification.contact;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ContactCriteria {

  private Integer limit;
  private Integer offset;
  private String keyword;
  private String timeCreatedFrom;
  private String timeCreatedTo;
  private String timeCreated;
  private Integer status;

}
