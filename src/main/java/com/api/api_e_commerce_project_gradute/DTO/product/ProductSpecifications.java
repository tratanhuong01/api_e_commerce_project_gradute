package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.detail_function_product.DetailFunctionProduct;
import com.api.api_e_commerce_project_gradute.info_product.InfoProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product.Product_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Set;

public final class ProductSpecifications {

  @PersistenceContext
  static EntityManager em;

  static Specification<Product> productSpecification = null;

  public static Specification<Product> createProductSpecifications(ProductCriteria productCriteria) {
    productSpecification = null;
    groupProduct(productCriteria.getSlugGroupProduct(),productCriteria.getSorter());
    brand(productCriteria.getBrand());
    color(productCriteria.getColor());
    ram(productCriteria.getRam());
    rom(productCriteria.getRom());
    price(productCriteria.getPriceFrom(),productCriteria.getPriceTo(),productCriteria.getSlugGroupProduct());
    feature(productCriteria.getFeature());
    typeProduct(productCriteria.getTypeProduct());
    return productSpecification;
  }

  public static Specification<Product> groupProduct(String slugGroupProduct,String sorter) {
    if (slugGroupProduct != null)
      if (sorter != null) {
        if (productSpecification == null)
          productSpecification = returnSorter(sorter,slugGroupProduct);
        else
          productSpecification = productSpecification.and(returnSorter(sorter,slugGroupProduct));
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
     else {
      if (sorter != null) {
        if (productSpecification == null)
          productSpecification = returnSorter(sorter);
        else
          productSpecification = productSpecification.and(returnSorter(sorter));
      }
      else {
        if (productSpecification == null)
          productSpecification = (root, query, builder) -> {
            return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
          };
        else
          productSpecification = productSpecification.and((root, query, builder) -> {
            return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
          });
      }
    }
    return productSpecification;
  }

  public static Specification<Product> returnSorter(String sorter,String slugGroupProduct) {
    Specification<Product> specification = null;
    switch (sorter) {
      case "0" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(joinInfoProduct.get("timeInput")));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "1" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(joinInfoProduct.get("itemSold")));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "2" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(builder.max(joinInfoProduct.get("sale")))).
              groupBy(joinInfoProduct.get("infoProduct").get("id"));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "3" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(builder.max(joinInfoProduct.get("priceOutput")))).
              groupBy(joinInfoProduct.get("infoProduct").get("id"));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "4" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.asc(builder.max(joinInfoProduct.get("priceOutput")))).
              groupBy(joinInfoProduct.get("infoProduct").get("id"));
          return joinInfoProduct.join("infoProduct").join("lineProduct",JoinType.INNER).join("groupProduct").
              get("slugGroupProduct").in(slugGroupProduct);
        };
        break;
      case "5" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(builder.max(joinInfoProduct.get("review")))).groupBy(joinInfoProduct.get("infoProduct").get("id"));
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

  public static Specification<Product> returnSorter(String sorter) {
    Specification<Product> specification = null;
    switch (sorter) {
      case "0" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(joinInfoProduct.get("timeInput")));
          return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
        };
        break;
      case "1" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(joinInfoProduct.get("itemSold")));
          return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
        };
        break;
      case "2" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(builder.max(joinInfoProduct.get("sale")))).
              groupBy(joinInfoProduct.get("infoProduct").get("id"));
          return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
        };
        break;
      case "3" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(builder.max(joinInfoProduct.get("priceOutput")))).
              groupBy(joinInfoProduct.get("infoProduct").get("id"));
          return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
        };
        break;
      case "4" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.asc(builder.max(joinInfoProduct.get("priceOutput")))).
              groupBy(joinInfoProduct.get("infoProduct").get("id"));
          return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
        };
        break;
      case "5" :
        specification =  (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          query.orderBy(builder.desc(builder.max(joinInfoProduct.get("review")))).groupBy(joinInfoProduct.get("infoProduct").get("id"));
          return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
        };
        break;
      default:
        specification = (root,query,builder) -> {
          return root.join("lineProduct").join("groupProduct").join("categoryGroupProduct").isNotNull();
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

  public static Specification<Product> typeProduct(Set<Integer> typeProduct) {
    if (typeProduct != null)
      if (productSpecification == null)
        productSpecification = (root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          return joinInfoProduct.get("typeInfoProduct").in(typeProduct);
        };
      else
        productSpecification = productSpecification.and((root, query, builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          return joinInfoProduct.get("typeInfoProduct").in(typeProduct);
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
    {
      if (slug == null) {
        if (productSpecification != null)
          productSpecification.and(productSpecification = (root, query, builder) -> {
            query.distinct(true);
            Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
            Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.greaterThanOrEqualTo(infoProductRoot.get("priceOutput"), priceFrom),
                    builder.lessThan(infoProductRoot.get("priceOutput"), priceTo)));
          });
        else
          productSpecification = (root, query, builder) -> {
            query.distinct(true);
            Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
            Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.greaterThanOrEqualTo(infoProductRoot.get("priceOutput"), priceFrom),
                    builder.lessThan(infoProductRoot.get("priceOutput"), priceTo)));
          };
      }
      else {
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
      }
    }
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
