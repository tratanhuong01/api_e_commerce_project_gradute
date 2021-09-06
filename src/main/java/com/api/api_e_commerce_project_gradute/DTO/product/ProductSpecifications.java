package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.Set;

public final class ProductSpecifications {

  static Specification<Product> productSpecification = null;

  public static Specification<Product> createProductSpecifications(ProductCriteria productCriteria) {
    productSpecification = feature(productCriteria.getFeature()).and(color(productCriteria.getColor()))
    .and(brand(productCriteria.getBrand())).and(ram(productCriteria.getColor())).and(rom(productCriteria.getRom()));
    return productSpecification;
  }

  public static Specification<Product> color(Set<Long> colors) {
    if (colors != null)
        productSpecification = (root, query, builder) -> {
          return root.join("colorProduct").get("id").in(colors);
        };
    return productSpecification;
  }

  public static Specification<Product> rom(Set<Long> roms) {
    if (roms != null)
        productSpecification = (root, query, builder) -> {
          return root.join("romProduct").get("id").in(roms);
        };

    return productSpecification;
  }

  public static Specification<Product> ram(Set<Long> rams) {
    if (rams != null)
        productSpecification = (root, query, builder) -> {
          return root.join("ramProduct").get("id").in(rams);
        };

    return productSpecification;
  }

  public static Specification<Product> brand(Set<String> brands) {
    if (brands != null)
        productSpecification = (root, query, builder) -> {
          return root.join("brandProduct").get("id").in(brands);
        };
    return productSpecification;
  }

  public static Specification<DetailFunctionProduct>  test(Set<Long> features) {
      return  (root, query, builder) -> {
        return root.join("lineProduct").get("id").in(features);
      };
  }

  public static Specification<Product> feature(Set<Long> features) {
    if (features != null)
    {
      productSpecification = (root, query, builder) -> {
        query.distinct(true);
        Subquery<DetailFunctionProduct> queryData = query.subquery(DetailFunctionProduct.class);
        Root<DetailFunctionProduct> detailFunctionProductRoot = queryData.from(DetailFunctionProduct.class);
        Expression<Collection<Product>> collectionExpression =
            detailFunctionProductRoot.join("lineProductFunctionProduct").get("id");
        queryData.select(detailFunctionProductRoot);
        queryData.where(detailFunctionProductRoot.join("functionProductDetail").get("id").in(features));
        return builder.exists(queryData);
      };
    }
    return productSpecification;
  }

}
