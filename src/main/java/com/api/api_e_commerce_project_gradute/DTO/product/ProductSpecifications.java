package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product_output.ProductOutput;
import com.api.api_e_commerce_project_gradute.sale.Sale;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public final class ProductSpecifications {

  static Specification<Product> productSpecification = null;

  public static Specification<Product> createProductSpecifications(ProductCriteria productCriteria) {
    feature(productCriteria.getFeature());
    color(productCriteria.getColor());
    brand(productCriteria.getBrand());
    ram(productCriteria.getColor());
    rom(productCriteria.getRom());
    price(productCriteria.getPriceFrom(),productCriteria.getPriceTo());
    return productSpecification;
  }

  public static Specification<Product> color(Set<Long> colors) {
    if (colors != null)
       if (productSpecification != null)
         productSpecification = productSpecification.and((root, query, builder) -> {
           return root.join("colorProduct").get("id").in(colors);
         });
       else
         productSpecification = (root, query, builder) -> {
           return root.join("colorProduct").get("id").in(colors);
         };
    return productSpecification;
  }

  public static Specification<Product> rom(Set<Long> roms) {
    if (roms != null)
        if (productSpecification != null)
            productSpecification = productSpecification.and(productSpecification = (root, query, builder) -> {
              return root.join("romProduct").get("id").in(roms);
            });
        else
          productSpecification = (root, query, builder) -> {
            return root.join("romProduct").get("id").in(roms);
          };
    return productSpecification;
  }

  public static Specification<Product> ram(Set<Long> rams) {
    if (rams != null)
        if (productSpecification != null)
          productSpecification = productSpecification.and(productSpecification = (root, query, builder) -> {
            return root.join("ramProduct").get("id").in(rams);
          });
        else
          productSpecification = (root, query, builder) -> {
            return root.join("ramProduct").get("id").in(rams);
          };
    return productSpecification;
  }

  public static Specification<Product> brand(Set<String> brands) {
    if (brands != null)
        if (productSpecification != null)
          productSpecification = productSpecification.and(productSpecification = (root, query, builder) -> {
            return root.join("brandProduct").get("id").in(brands);
          });
        else
          productSpecification = (root, query, builder) -> {
            return root.join("brandProduct").get("id").in(brands);
          };
    return productSpecification;
  }
  public static Specification<Product> price(Integer priceFrom , Integer priceTo) {
    if (priceFrom != null && priceTo != null)
      if (productSpecification != null)
        productSpecification.and(productSpecification = (root, query, builder) -> {
          query.distinct(true);
          Subquery<ProductOutput> queryData = query.subquery(ProductOutput.class);
          Root<ProductOutput> productOutputRoot = queryData.from(ProductOutput.class);
          queryData.select(productOutputRoot);
          queryData.where(builder.greaterThanOrEqualTo(productOutputRoot.get("priceOutput"), priceFrom),
              builder.lessThan(productOutputRoot.get("priceOutput"), priceTo));

          return builder.exists(queryData);
        });
      else
        productSpecification = (root, query, builder) -> {
          query.distinct(true);
          Subquery<ProductOutput> queryData = query.subquery(ProductOutput.class);
          Root<ProductOutput> productOutputRoot = queryData.from(ProductOutput.class);
          queryData.select(productOutputRoot);
          queryData.where(builder.greaterThanOrEqualTo(productOutputRoot.get("priceOutput"), priceFrom),
              builder.lessThan(productOutputRoot.get("priceOutput"), priceTo));
          return builder.exists(queryData);
        };
    return productSpecification;
  }

  public static Specification<Product> feature(Set<Long> features) {
    if (features != null)
      if (productSpecification != null)
        productSpecification = productSpecification.and(productSpecification = (root, query, builder) -> {
          query.distinct(true);
          Subquery<DetailFunctionProduct> queryData = query.subquery(DetailFunctionProduct.class);
          Root<DetailFunctionProduct> detailFunctionProductRoot = queryData.from(DetailFunctionProduct.class);
          Expression<Collection<Product>> collectionExpression =
              detailFunctionProductRoot.join("lineProductFunctionProduct").get("id");
          queryData.select(detailFunctionProductRoot);
          queryData.where(detailFunctionProductRoot.join("functionProductDetail").get("id").in(features));
          return builder.exists(queryData);
        });
      else
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
    return productSpecification;
  }

}
