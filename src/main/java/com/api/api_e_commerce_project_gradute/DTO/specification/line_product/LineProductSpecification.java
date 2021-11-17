package com.api.api_e_commerce_project_gradute.DTO.specification.line_product;

import com.api.api_e_commerce_project_gradute.line_product.LineProduct;
import org.springframework.data.jpa.domain.Specification;

public final class LineProductSpecification {

  static Specification<LineProduct> lineProductSpecification = null;

  public static Specification<LineProduct> createLineProductSpecification(LineProductCriteria lineProductCriteria) {
    lineProductSpecification = null;
    brand(lineProductCriteria.getBrand());
    group(lineProductCriteria.getGroup());
    keyword(lineProductCriteria.getKeyword());
    timeCreated(lineProductCriteria.getTimeCreatedFrom(),lineProductCriteria.getTimeCreatedTo());
    return lineProductSpecification;
  }

  public static Specification<LineProduct> brand(String brand) {
    if (brand != null)
      if (lineProductSpecification == null)
        lineProductSpecification = (root,query,builder)-> {
            return builder.equal(root.join("brandProduct").get("id"),brand);
        };
      else
        lineProductSpecification = lineProductSpecification.and(lineProductSpecification = (root,query,builder)-> {
          return builder.equal(root.join("brandProduct").get("id"),brand);
        });
    return lineProductSpecification;
  }

  public static Specification<LineProduct> group(String group) {
    if (group != null)
      if (lineProductSpecification == null)
        lineProductSpecification = (root,query,builder)-> {
          return builder.equal(root.join("groupProduct").get("id"),group);
        };
      else
        lineProductSpecification = lineProductSpecification.and(lineProductSpecification = (root,query,builder)-> {
          return builder.equal(root.join("groupProduct").get("id"),group);
        });
    return lineProductSpecification;
  }

  public static Specification<LineProduct> keyword(String keyword) {
    if (keyword != null)
      if (lineProductSpecification == null)
        lineProductSpecification = (root,query,builder) -> {
          return builder.or(builder.like(root.get("nameLineProduct"),"%" + keyword + "%"));
        };
      else
        lineProductSpecification = lineProductSpecification.and((root,query,builder) -> {
          return builder.or(builder.like(root.get("nameLineProduct"),"%" + keyword + "%"));
        });
    return lineProductSpecification;
  }
  public static Specification<LineProduct> timeCreated(String timeCreatedFrom, String timeCreatedTo) {
    if (timeCreatedFrom != null & timeCreatedTo != null) {
      if (lineProductSpecification == null) {
        lineProductSpecification = (root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " 00:00:00"),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " 00:00:00"));
        };
      }
      else {
        lineProductSpecification = lineProductSpecification.and((root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " 00:00:00"),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " 00:00:00"));
        });
      }
    }
    return lineProductSpecification;
  }
}
