package com.api.api_e_commerce_project_gradute.DTO.specification.contact;

import com.api.api_e_commerce_project_gradute.contact.Contact;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ContactSpecification {

  static Specification<Contact> contactSpecification = null;

  public static Specification<Contact> createContactSpecification(ContactCriteria contactCriteria) {
    contactSpecification = null;
    sorter("timeCreated",contactCriteria.getTimeCreated());
    timeCreated(contactCriteria.getTimeCreatedFrom(),contactCriteria.getTimeCreatedTo());
    search(contactCriteria.getKeyword());
    status(contactCriteria.getStatus());
    return contactSpecification;
  }

  public static Specification<Contact> sorter(String typeSorter,String dataSorter) {
    if (dataSorter != null)
      if (contactSpecification == null)
        contactSpecification = (root,query,builder) -> {
          if (dataSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get(typeSorter)));
          else
            query.orderBy(builder.desc(root.get(typeSorter)));
          return root.get("id").isNotNull();
        };
      else
        contactSpecification = contactSpecification.and( (root,query,builder) -> {
          if (dataSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get(typeSorter)));
          else
            query.orderBy(builder.desc(root.get(typeSorter)));
          return root.get("id").isNotNull();
        });
    return contactSpecification;
  }

  public static Specification<Contact> search(String keyword) {
    if (keyword != null)
      if (contactSpecification == null)
        contactSpecification = (root,query,builder) -> {
          return builder.or(
              builder.like(root.get("content"),"%" +keyword+ "%"),
              builder.like(root.get("email"),"%" +keyword+ "%"),
              builder.like(root.get("fullName"),"%" +keyword+ "%"),
              builder.like(root.get("phone"),"%" +keyword+ "%"));
          };
      else
        contactSpecification = contactSpecification.and((root,query,builder) -> {
          return builder.or(
              builder.like(root.get("content"),"%" +keyword+ "%"),
              builder.like(root.get("fullName"),"%" +keyword+ "%"),
              builder.like(root.get("email"),"%" +keyword+ "%"),
              builder.like(root.get("phone"),"%" +keyword+ "%"));
        });
    return contactSpecification;
  }

  public static Specification<Contact> timeCreated(String timeCreatedFrom, String timeCreatedTo) {
    if (timeCreatedFrom != null & timeCreatedTo != null) {
      if (contactSpecification == null) {
        contactSpecification = (root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        };
      }
      else {
        contactSpecification = contactSpecification.and((root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        });
      }
    }
    return contactSpecification;
  }

  public static Specification<Contact> status(Integer status) {
    if (status != null) {
      if (contactSpecification == null)
          contactSpecification = (root,query,builder)  -> {
            return builder.equal(root.get("status"),status);
          };
      else
        contactSpecification = contactSpecification.and((root,query,builder)  -> {
          return builder.equal(root.get("status"),status);
        });
    }
    return contactSpecification;
  }

}
