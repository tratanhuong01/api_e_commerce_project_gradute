package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProduct;
import com.api.api_e_commerce_project_gradute.info_product.InfoProduct;
import com.api.api_e_commerce_project_gradute.line_product.LineProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product.Product_;
import org.hibernate.Metamodel;
import org.hibernate.type.EntityType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

public final class ProductSpecifications {

  @PersistenceContext
  static EntityManager em;

  static Specification<Product> productSpecification = null;

  public static Specification<Product> createProductSpecifications(ProductCriteria productCriteria) {
    productSpecification = null;
    groupProduct(productCriteria.getSlugGroupProduct(),productCriteria.getFilter());
    brand(productCriteria.getBrand());
    color(productCriteria.getColor());
    ram(productCriteria.getRam());
    rom(productCriteria.getRom());
    price(productCriteria.getPriceFrom(),productCriteria.getPriceTo(),productCriteria.getSlugGroupProduct());
    feature(productCriteria.getFeature());
//    filter(productCriteria.getFilter());
    return productSpecification;
  }

  public static Specification<Product> groupProduct(String slugGroupProduct,String filter) {
    if (slugGroupProduct != null)
      if (filter != null) {
        if (productSpecification == null)
          productSpecification = returnFilter(filter,slugGroupProduct);
        else
          productSpecification = productSpecification.and(returnFilter(filter,slugGroupProduct));
      }
      else {
        if (productSpecification == null)
          productSpecification = (root, query, builder) -> {
            return root.join("lineProduct",JoinType.INNER).join("groupProduct").
                get("slugGroupProduct").in(slugGroupProduct);
          };
        else
          productSpecification = productSpecification.and((root, query, builder) -> {
            return root.join("lineProduct",JoinType.INNER).join("groupProduct").
                get("slugGroupProduct").in(slugGroupProduct);
          });
      }
    return productSpecification;
  }

  public static Specification<Product> returnFilter(String filter,String slugGroupProduct) {
    Specification<Product> specification = null;
    switch (filter) {
      case "2" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(joinInfoProduct.get("sale")));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "3" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(joinInfoProduct.get("priceOutput")));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "4" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.asc(joinInfoProduct.get("priceOutput")));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "5" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(joinInfoProduct.get("review")));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      default:
        specification = (root,query,builder) -> {
          return root.join("lineProduct", JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
    }
    return specification;
  }

  public static Specification<Product> color(Set<Long> colors) {
    if (colors != null)
      if (productSpecification == null)
         productSpecification = (root, query, builder) -> {
           return root.join("colorProduct",JoinType.LEFT).get("id").in(colors);
         };
      else
        productSpecification = productSpecification.and((root, query, builder) -> {
          return root.join("colorProduct",JoinType.LEFT).get("id").in(colors);
        });
    return productSpecification;
  }

  public static Specification<Product> rom(Set<Long> roms) {
    if (roms != null)
        if (productSpecification == null)
          productSpecification = (root, query, builder) -> {
            return root.join("romProduct",JoinType.LEFT).get("id").in(roms);
          };
        else
          productSpecification = productSpecification.and((root, query, builder) -> {
            return root.join("romProduct",JoinType.LEFT).get("id").in(roms);
          });
    return productSpecification;
  }

  public static Specification<Product> ram(Set<Long> rams) {
    if (rams != null)
        if (productSpecification == null)
          productSpecification = (root, query, builder) -> {
            return root.join("ramProduct",JoinType.LEFT).get("id").in(rams);
          };
        else
          productSpecification = productSpecification.and((root, query, builder) -> {
            return root.join("ramProduct",JoinType.LEFT).get("id").in(rams);
          });
    return productSpecification;
  }

  public static Specification<Product> brand(Set<String> brands) {
    if (brands != null)
        if (productSpecification == null)
          productSpecification = (root, query, builder) -> {
            return root.join("brandProduct",JoinType.LEFT).get("id").in(brands);
          };
        else
          productSpecification = productSpecification.and((root, query, builder) -> {
            return root.join("brandProduct",JoinType.LEFT).get("id").in(brands);
          });
    return productSpecification;
  }

  public static Specification<Product> price(Integer priceFrom , Integer priceTo,String slug) {
    if (priceFrom != null && priceTo != null)
      if (productSpecification != null)
        productSpecification.and(productSpecification = (root, query, builder) -> {
          query.distinct(true);
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
              .where(builder.greaterThanOrEqualTo(infoProductRoot.get("priceOutput"), priceFrom),
                  builder.lessThan(infoProductRoot.get("priceOutput"), priceTo),
                  builder.equal(infoProductRoot.get("infoProduct").get("lineProduct").
                      get("groupProduct").get("slugGroupProduct"),slug)));
        });
      else
        productSpecification = (root, query, builder) -> {
          query.distinct(true);
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
              .where(builder.greaterThanOrEqualTo(infoProductRoot.get("priceOutput"), priceFrom),
                  builder.lessThan(infoProductRoot.get("priceOutput"), priceTo),
                  builder.equal(infoProductRoot.get("infoProduct").get("lineProduct").
                      get("groupProduct").get("slugGroupProduct"),slug)));
        };
    return productSpecification;
  }

  public static Specification<Product> feature(Set<Long> features) {
    if (features != null)
        if (productSpecification == null)
          productSpecification = (root, query, builder) -> {
            Subquery<DetailFunctionProduct> queryData = query.subquery(DetailFunctionProduct.class);
            Root<DetailFunctionProduct> detailFunctionProductRoot = queryData.from(DetailFunctionProduct.class);
            return root.join("lineProduct").get("id").in(queryData.select(
                detailFunctionProductRoot.join("lineProductFunctionProduct").get("id")).
                where(detailFunctionProductRoot.join("functionProductDetail").get("id").in(features)));
          };
        else
          productSpecification = productSpecification.and((root, query, builder) -> {
            Subquery<DetailFunctionProduct> queryData = query.subquery(DetailFunctionProduct.class);
            Root<DetailFunctionProduct> detailFunctionProductRoot = queryData.from(DetailFunctionProduct.class);
            return root.join("lineProduct").get("id").in(queryData.select(
                detailFunctionProductRoot.join("lineProductFunctionProduct").get("id")).
                where(detailFunctionProductRoot.join("functionProductDetail").get("id").in(features)));
          });
    return productSpecification;
  }

  public static Specification<Product> filter(String filter) {
    if (filter != null) {
      if (productSpecification == null)
        switch (filter) {
          case "0" :
            productSpecification = (root, query, builder) -> {
              Join<Product, InfoProduct> join = root.join(Product_.infoProduct);
              Predicate equalPredicate = builder.equal(join.get("sale"), 9);
              return equalPredicate;
            };
            return productSpecification;
        }
    }
    return productSpecification;
  }

}
