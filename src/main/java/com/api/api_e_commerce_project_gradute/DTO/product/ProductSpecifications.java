package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProduct;
import com.api.api_e_commerce_project_gradute.info_product.InfoProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

public final class ProductSpecifications {

  static Specification<Product> productSpecification = null;

  public static Specification<Product> createProductSpecifications(ProductCriteria productCriteria) {
    productSpecification = null;
    groupProduct(productCriteria.getSlugGroupProduct());
    feature(productCriteria.getFeature());
    brand(productCriteria.getBrand());
    color(productCriteria.getColor());
    ram(productCriteria.getRam());
    rom(productCriteria.getRom());
    price(productCriteria.getPriceFrom(),productCriteria.getPriceTo());
    return productSpecification;
  }

  public static Specification<Product> groupProduct(String slugGroupProduct) {
    if (slugGroupProduct != null)
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
    return productSpecification;
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

  public static Specification<Product> price(Integer priceFrom , Integer priceTo) {
    if (priceFrom != null && priceTo != null)
      if (productSpecification != null)
        productSpecification.and(productSpecification = (root, query, builder) -> {
          query.distinct(true);
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          queryData.select(infoProductRoot);
          queryData.where(builder.greaterThanOrEqualTo(infoProductRoot.get("priceOutput"), priceFrom),
              builder.lessThan(infoProductRoot.get("priceOutput"), priceTo));

          return builder.exists(queryData);
        });
      else
        productSpecification = (root, query, builder) -> {
          query.distinct(true);
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          queryData.select(infoProductRoot);
          queryData.where(builder.greaterThanOrEqualTo(infoProductRoot.get("priceOutput"), priceFrom),
              builder.lessThan(infoProductRoot.get("priceOutput"), priceTo));
          return builder.exists(queryData);
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

}
