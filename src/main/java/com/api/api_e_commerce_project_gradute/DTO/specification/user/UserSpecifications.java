package com.api.api_e_commerce_project_gradute.DTO.specification.user;

import com.api.api_e_commerce_project_gradute.user.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public final class UserSpecifications {

  static Specification<User> userSpecification = null;

  public static Specification<User> createUserSpecification(UserCriteria userCriteria) {
    userSpecification = null;
    typeUser(userCriteria.getUserType());
    sexFilter(userCriteria.getSex());
    status(userCriteria.getStatus());
    age(userCriteria.getAgeFrom(), userCriteria.getAgeTo());
    verify(userCriteria.getVerifyPhone(), userCriteria.getVerifyEmail());
    sorter(userCriteria.getTimeRegisterSorter(),userCriteria.getAgeSorter());
    search(userCriteria.getKeyword());
    isRegister(userCriteria.getIsRegister());
    timeCreated(userCriteria.getTimeCreatedFrom(),userCriteria.getTimeCreatedTo());
    return userSpecification;
  }

  public static Specification<User> sexFilter(String sex) {
    if (sex != null)
      if (userSpecification == null)
        userSpecification = (root,query,builder) -> {
          return builder.equal(root.get("sex"),sex);
        };
      else
        userSpecification = userSpecification.and((root,query,builder) -> {
          return builder.equal(root.get("sex"), sex);
        });
    return userSpecification;
  }

  public static Specification<User> isRegister(Integer isRegister) {
    if (isRegister != null)
      if (userSpecification == null)
        userSpecification = (root,query,builder) -> {
          return builder.equal(root.get("isRegister"),isRegister);
        };
      else
        userSpecification = userSpecification.and((root,query,builder) -> {
          return builder.equal(root.get("isRegister"), isRegister);
        });
    return userSpecification;
  }

  public static Specification<User> typeUser(Integer typeUser) {
    if (typeUser != null)
      if (userSpecification == null)
        userSpecification = (root,query,builder) -> {
          return builder.equal(root.get("type"),typeUser);
        };
      else
        userSpecification = userSpecification.and((root,query,builder) -> {
          return builder.equal(root.get("type"), typeUser);
        });
    return userSpecification;
  }

  public static Specification<User> status(Integer status) {
    if (status != null)
      if (userSpecification == null)
        userSpecification = (root,query,builder) -> {
          return builder.equal(root.get("status"),status);
        };
      else
        userSpecification = userSpecification.and((root,query,builder) -> {
          return builder.equal(root.get("status"), status);
        });
    return userSpecification;
  }

  public static Specification<User> age(Integer ageFrom,Integer ageTo) {
    if (ageFrom != null & ageTo != null)
      if (userSpecification == null)
        userSpecification = (root,query,builder) -> {
          Subquery<User> queryData = query.subquery(User.class);
          Root<User> userSubQuery = queryData.from(User.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(builder.greaterThanOrEqualTo(
              builder.function("DATEDIFF", Long.class,
                  builder.literal(Timestamp.valueOf(LocalDateTime.now())),
                  root.get("birthday")
              ),Long.parseLong(String.valueOf(ageFrom))),
              builder.lessThanOrEqualTo(builder.function("DATEDIFF", Long.class,
                  builder.literal(Timestamp.valueOf(LocalDateTime.now())),
                  root.get("birthday")
              ),Long.parseLong(String.valueOf(ageTo)))));
        };
      else
        userSpecification = userSpecification.and((root,query,builder) -> {
          Subquery<User> queryData = query.subquery(User.class);
          Root<User> userSubQuery = queryData.from(User.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(builder.greaterThanOrEqualTo(
              builder.function("DATEDIFF", Long.class,
                  builder.literal(Timestamp.valueOf(LocalDateTime.now())),
                  root.get("birthday")
              ),Long.parseLong(String.valueOf(ageFrom))),
              builder.lessThanOrEqualTo(builder.function("DATEDIFF", Long.class,
                  builder.literal(Timestamp.valueOf(LocalDateTime.now())),
                  root.get("birthday")
              ),Long.parseLong(String.valueOf(ageTo)))));
        });
    return userSpecification;
  }

  public static Specification<User> verify(Integer verifyPhone,Integer verifyEmail) {
    if (verifyEmail != null && verifyPhone != null)
      if (userSpecification == null)
        userSpecification = (root,query,builder) -> {
          Subquery<User> queryData = query.subquery(User.class);
          Root<User> userSubQuery = queryData.from(User.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(
              builder.equal(userSubQuery.get("isVerifyPhone"),verifyPhone),
              builder.equal(userSubQuery.get("isVerifyEmail"),verifyEmail)
              ));
        };
      else
        userSpecification = userSpecification.and((root,query,builder) -> {
          Subquery<User> queryData = query.subquery(User.class);
          Root<User> userSubQuery = queryData.from(User.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(
              builder.equal(userSubQuery.get("isVerifyPhone"),verifyPhone),
              builder.equal(userSubQuery.get("isVerifyEmail"),verifyEmail)
          ));
        });
    return userSpecification;
  }

  public static Specification<User> sorter(String timeRegisterSorter,String ageSorter) {
    if (ageSorter != null)
      if (userSpecification == null) {
        userSpecification = (root,query,builder) -> {
          if (ageSorter != null)
            if (ageSorter.equals("ASC"))
                query.orderBy(builder.desc(root.get("birthday")));
            else
                query.orderBy(builder.asc(root.get("birthday")));
          return root.get("id").isNotNull();
        };
      }

      else
        userSpecification = userSpecification.and((root,query,builder) -> {
          if (ageSorter != null)
            if (ageSorter.equals("ASC"))
              query.orderBy(builder.desc(root.get("birthday")));
            else
              query.orderBy(builder.asc(root.get("birthday")));
          return root.get("id").isNotNull();
        });
    if (userSpecification == null) {
      userSpecification = (root,query,builder) -> {
        if (timeRegisterSorter != null)
          if (timeRegisterSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get("timeCreated")));
          else
            query.orderBy(builder.desc(root.get("timeCreated")));
        return root.get("id").isNotNull();
      };
    }

    else
      userSpecification = userSpecification.and((root,query,builder) -> {
        if (timeRegisterSorter != null)
          if (timeRegisterSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get("timeCreated")));
          else
            query.orderBy(builder.desc(root.get("timeCreated")));
        return root.get("id").isNotNull();
      });
    return userSpecification;
  }

  public static Specification<User> search(String keyword) {
    if (keyword !=  null)
      if (userSpecification == null)  {
        userSpecification = (root,query,builder)-> {
          Subquery<User> queryData = query.subquery(User.class);
          Root<User> userSubQuery = queryData.from(User.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(
              builder.or(builder.like(userSubQuery.get("id"),"%" +keyword+ "%"),builder.like(userSubQuery.get("email")
                  ,"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("phone"),"%" +keyword+ "%"),builder.like(userSubQuery.get("firstName"),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("lastName"),"%" +keyword+ "%"))
          ));
        };
      }
      else {
        userSpecification = userSpecification.and((root,query,builder)-> {
          Subquery<User> queryData = query.subquery(User.class);
          Root<User> userSubQuery = queryData.from(User.class);
          return root.get("id").in(queryData.select(userSubQuery.get("id")).where(
              builder.or(builder.like(userSubQuery.get("id"),"%" +keyword+ "%"),builder.like(userSubQuery.get("email")
                  ,"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("phone"),"%" +keyword+ "%"),builder.like(userSubQuery.get("firstName"),"%" +keyword+ "%"),
                  builder.like(userSubQuery.get("lastName"),"%" +keyword+ "%"))
          ));
        });
      }
    return userSpecification;
  }
  public static Specification<User> timeCreated(String timeCreatedFrom, String timeCreatedTo) {
    if (timeCreatedFrom != null & timeCreatedTo != null) {
      if (userSpecification == null) {
        userSpecification = (root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated"),timeCreatedFrom),
              builder.lessThanOrEqualTo(root.get("timeCreated"),timeCreatedTo));
        };
      }
      else {
        userSpecification = userSpecification.and((root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated"),timeCreatedFrom),
              builder.lessThanOrEqualTo(root.get("timeCreated"),timeCreatedTo));
        });
      }
    }
    return userSpecification;
  }

}
