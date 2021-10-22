package com.api.api_e_commerce_project_gradute.DTO.specification.bill;

import com.api.api_e_commerce_project_gradute.bill.Bill;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

public final class BillSpecifications {
  static Specification<Bill> billSpecification = null;

  public static Specification<Bill> createBillSpecification(BillCriteria billCriteria) {
    billSpecification = null;
    status(billCriteria.getStatus());
    search(billCriteria.getKeyword());
    sorter(billCriteria.getTimeCompletedSorter(), "timeCompleted");
    sorter(billCriteria.getTimeCreatedSorter(), "timeCreated");
    sorter(billCriteria.getFeeDeliverySorter(), "fee");
    sorter(billCriteria.getMoneyOrderSorter(), "total");
    timeCreated(billCriteria.getTimeCreatedFrom(),billCriteria.getTimeCreatedTo());
    return billSpecification;
  }

  public static Specification<Bill> status(Integer status) {
    if (status != null)
      if (billSpecification == null)
        billSpecification = (root,query,builder) -> {
          return builder.equal(root.get("status"),status);
        };
      else
        billSpecification = billSpecification.and((root,query,builder)-> {
          return builder.equal(root.get("status"),status);
        });
    return billSpecification;
  }

  public static Specification<Bill> search(String keyword) {
    if (keyword !=  null)
      if (billSpecification == null)  {
        billSpecification = (root,query,builder)-> {
          Subquery<Bill> queryData = query.subquery(Bill.class);
          Root<Bill> userSubQuery = queryData.from(Bill.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(
              builder.or(builder.like(userSubQuery.get("id").as(String.class),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("phone"),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("fullName"),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("address"),"%" +keyword+ "%"))
          ));
        };
      }
      else {
        billSpecification = billSpecification.and((root,query,builder)-> {
          Subquery<Bill> queryData = query.subquery(Bill.class);
          Root<Bill> userSubQuery = queryData.from(Bill.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(
              builder.or(builder.like(userSubQuery.get("id").as(String.class),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("phone"),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("fullName"),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("address"),"%" +keyword+ "%"))
          ));
        });
      }
    return billSpecification;
  }

  public static Specification<Bill> sorter(String typeSorter,String dataSorter) {
    if (typeSorter != null)
      if (billSpecification == null) {
        billSpecification = (root,query,builder) -> {
          if (typeSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get(dataSorter)));
          else
            query.orderBy(builder.desc(root.get(dataSorter)));
          return root.get("id").isNotNull();
        };
      }

      else
        billSpecification = billSpecification.and((root,query,builder) -> {
          if (typeSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get(dataSorter)));
          else
            query.orderBy(builder.desc(root.get(dataSorter)));
          return root.get("id").isNotNull();
        });

    return billSpecification;
  }

  public static Specification<Bill> timeCreated(String timeCreatedFrom,String timeCreatedTo) {
    if (timeCreatedFrom != null & timeCreatedTo != null) {
      if (billSpecification == null) {
        billSpecification = (root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated"),timeCreatedFrom),
              builder.lessThanOrEqualTo(root.get("timeCreated"),timeCreatedTo));
        };
      }
      else {
        billSpecification = billSpecification.and((root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated"),timeCreatedFrom),
              builder.lessThanOrEqualTo(root.get("timeCreated"),timeCreatedTo));
        });
      }
    }
    return billSpecification;
  }

}
