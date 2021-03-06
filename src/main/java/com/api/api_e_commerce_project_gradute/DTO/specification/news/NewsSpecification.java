package com.api.api_e_commerce_project_gradute.DTO.specification.news;

import com.api.api_e_commerce_project_gradute.news.News;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class NewsSpecification {

  static Specification<News> newsSpecification = null;

  public static Specification<News> createNewsSpecification(NewsCriteria newsCriteria) {
    newsSpecification = null;
    poster(newsCriteria.getPoster());
    category(newsCriteria.getCategory());
    sorter("view",newsCriteria.getViewSorter());
    sorter("commentCount",newsCriteria.getCommentSorter());
    search(newsCriteria.getKeyword());
    timeCreated(newsCriteria.getTimeCreatedFrom(),newsCriteria.getTimeCreatedTo());
    return newsSpecification;
  }

  public static Specification<News> poster(String poster) {
    if (poster != null)
      if (newsSpecification == null)
        newsSpecification = (root,query,builder)-> {
          return builder.equal(root.get("userNews").get("id"),poster);
        };
      else
        newsSpecification = newsSpecification.and((root,query,builder)-> {
          return builder.equal(root.get("userNews").get("id"),poster);
        });
    return newsSpecification;
  }

  public static Specification<News> category(String category) {
    if (category != null)
      if (newsSpecification == null)
        newsSpecification = (root,query,builder) -> {
          return  builder.equal(root.get("categoryNews").get("id"),category);
        };
      else
        newsSpecification = newsSpecification.and((root,query,builder) -> {
          return  builder.equal(root.get("categoryNews").get("id"),category);
        });
    return newsSpecification;
  }

  public static Specification<News> sorter(String typeSorter,String dataSorter) {
    if (dataSorter != null)
      if (newsSpecification == null)
        newsSpecification = (root,query,builder) -> {
          if (dataSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get(typeSorter)));
          else
            query.orderBy(builder.desc(root.get(typeSorter)));
          return root.get("id").isNotNull();
        };
      else
        newsSpecification = newsSpecification.and( (root,query,builder) -> {
          if (dataSorter.equals("ASC"))
            query.orderBy(builder.asc(root.get(typeSorter)));
          else
            query.orderBy(builder.desc(root.get(typeSorter)));
          return root.get("id").isNotNull();
        });
    return newsSpecification;
  }

  public static Specification<News> search(String keyword) {
    if (keyword != null)
      if (newsSpecification == null)
        newsSpecification = (root,query,builder) -> {
          Subquery<News> queryData = query.subquery(News.class);
          Root<News> newsRoot = queryData.from(News.class);
          return root.get("id").in(queryData.select(newsRoot.get("id")).where(
              builder.or(
                  builder.like(newsRoot.get("title"),"%" +keyword+ "%"),
                  builder.like(newsRoot.get("describeSmall"),"%" +keyword+ "%"))
              ));
        };
      else
        newsSpecification = newsSpecification.and((root,query,builder) -> {
          Subquery<News> queryData = query.subquery(News.class);
          Root<News> newsRoot = queryData.from(News.class);
          return root.get("id").in(queryData.select(newsRoot.get("id")).where(
              builder.or(
                  builder.like(newsRoot.get("title"),"%" +keyword+ "%"),
                  builder.like(newsRoot.get("describeSmall"),"%" +keyword+ "%"))
          ));
        });
    return newsSpecification;
  }
  public static Specification<News> timeCreated(String timeCreatedFrom, String timeCreatedTo) {
    if (timeCreatedFrom != null & timeCreatedTo != null) {
      if (newsSpecification == null) {
        newsSpecification = (root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        };
      }
      else {
        newsSpecification = newsSpecification.and((root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
        });
      }
    }
    return newsSpecification;
  }
}
