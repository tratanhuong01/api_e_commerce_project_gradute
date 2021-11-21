package com.api.api_e_commerce_project_gradute.DTO.specification.discount_code;

import com.api.api_e_commerce_project_gradute.discount_code.DiscountCode;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DiscountCodeSpecification {

  static Specification<DiscountCode> discountCodeSpecification = null;

  public static Specification<DiscountCode> createDiscountCodeSpecification(DiscountCodeCriteria discountCodeCriteria) {
    discountCodeSpecification = null;
    keyword(discountCodeCriteria.getKeyword());
    typeDiscountCode(discountCodeCriteria.getTypeDiscountCode());
    sorter("min", discountCodeCriteria.getMinSorter());
    sorter("max", discountCodeCriteria.getMaxSorter());
    sorter("percent", discountCodeCriteria.getPercentSorter());
    sorter("timeStart", discountCodeCriteria.getNewBestSorter());
    sorter("timeExpired", discountCodeCriteria.getNewBestSorter());
    timeCreated(discountCodeCriteria.getTimeCreatedFrom(),discountCodeCriteria.getTimeCreatedTo());
    return discountCodeSpecification;
  }

  public static Specification<DiscountCode> typeDiscountCode(Integer typeDiscountCode) {
    if (typeDiscountCode != null)
      if (discountCodeSpecification == null)
        discountCodeSpecification = (root,query,builder) -> {
          return builder.equal(root.get("type"),typeDiscountCode);
        };
      else
        discountCodeSpecification = discountCodeSpecification.and((root,query,builder) -> {
          return builder.equal(root.get("type"),typeDiscountCode);
        });
    return discountCodeSpecification;
  }

  public static Specification<DiscountCode> keyword(String keyword) {
    if (keyword != null)
      if (discountCodeSpecification == null)
        discountCodeSpecification = (root,query,builder) -> {
          return builder.or(builder.like(root.get("nameDiscountCode"),"%" + keyword + "%"),
              builder.like(root.get("code"),"%" + keyword + "%"));
        };
      else
        discountCodeSpecification = discountCodeSpecification.and((root,query,builder) -> {
          return builder.or(builder.like(root.get("nameDiscountCode"),"%" + keyword + "%"),
              builder.like(root.get("code"),"%" + keyword + "%"));
        });
    return discountCodeSpecification;
  }

  public static Specification<DiscountCode> sorter(String typeSorter,String dataSorter) {
    if (dataSorter != null)
      if (discountCodeSpecification == null)
        discountCodeSpecification = (root,query,builder) -> {
          query.orderBy(builder.desc(root.get(typeSorter)));
          return root.get("id").isNotNull();
        };
      else
        discountCodeSpecification = discountCodeSpecification.and((root,query,builder) -> {
          query.orderBy(builder.desc(root.get(typeSorter)));
          return root.get("id").isNotNull();
        });
    return discountCodeSpecification;
  }

  public static Specification<DiscountCode> expired(String expired) {
    if (expired != null)
      if (discountCodeSpecification == null)
        discountCodeSpecification = (root,query,builder) -> {
          Subquery<DiscountCode> subQuery = query.subquery(DiscountCode.class);
          Root<DiscountCode> discountCodeRoot = query.from(DiscountCode.class);
          return root.get("id").in(subQuery.select(discountCodeRoot.get("id")).where(builder.greaterThanOrEqualTo(
              builder.function("DATEDIFF", String.class,
                  builder.literal(Timestamp.valueOf(LocalDateTime.now())),
                  root.get("birthday")),String.valueOf(3))));
        };
    return discountCodeSpecification;
  }

  public static Specification<DiscountCode> timeCreated(String timeCreatedFrom, String timeCreatedTo) {
    if (timeCreatedFrom != null & timeCreatedTo != null) {
      if (discountCodeSpecification == null) {
        discountCodeSpecification = (root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom +" " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo+" " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        };
      }
      else {
        discountCodeSpecification = discountCodeSpecification.and((root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom+" " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo+" " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        });
      }
    }
    return discountCodeSpecification;
  }

}
