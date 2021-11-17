package com.api.api_e_commerce_project_gradute.DTO.specification.product;

import com.api.api_e_commerce_project_gradute.info_product.InfoProduct;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product.Product_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public final class ProductAdminSpecification {

  static Specification<Product> productSpecification = null;

  public static Specification<Product> createProductSpecification(ProductAdminCriteria productAdminCriteria) {
    productSpecification = null;
    typeProduct(productAdminCriteria.getTypeProduct());
    price(productAdminCriteria.getPriceFrom(),productAdminCriteria.getPriceTo(),"priceOutput");
    status(productAdminCriteria.getStatus());
    sorter(productAdminCriteria.getPriceInputSorter(),"priceInput");
    sorter(productAdminCriteria.getPriceOutputSorter(),"priceOutput");
    sorter(productAdminCriteria.getSaleSorter(),"sale");
    sorter(productAdminCriteria.getProductSoldSorter(),"itemSold");
    sorter(productAdminCriteria.getReviewSorter(),"review");
    search(productAdminCriteria.getKeyword());
    category(productAdminCriteria.getCategory());
    group(productAdminCriteria.getGroup());
    ram(productAdminCriteria.getRam());
    rom(productAdminCriteria.getRom());
    color(productAdminCriteria.getColor());
    brand(productAdminCriteria.getBrand());
    timeCreated(productAdminCriteria.getTimeCreatedFrom(),productAdminCriteria.getTimeCreatedTo());
    sorter(productAdminCriteria.getProductSoldSorter(),"timeCreated");
    return productSpecification;
  }

  public static Specification<Product> typeProduct(Integer typeProduct) {
    if (typeProduct != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
              .where(builder.equal(infoProductRoot.get("typeInfoProduct"),typeProduct)));
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
              .where(builder.equal(infoProductRoot.get("typeInfoProduct"),typeProduct)));
        });
   return productSpecification;
  }

  public static Specification<Product> price(Integer priceFrom , Integer priceTo,String priceData) {
    if (priceFrom != null && priceTo != null)
        if (productSpecification != null)
          productSpecification.and(productSpecification = (root, query, builder) -> {
            query.distinct(true);
            Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
            Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.greaterThanOrEqualTo(infoProductRoot.get(priceData), priceFrom),
                    builder.lessThan(infoProductRoot.get(priceData), priceTo)));
          });
        else
          productSpecification = (root, query, builder) -> {
            query.distinct(true);
            Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
            Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.greaterThanOrEqualTo(infoProductRoot.get(priceData), priceFrom),
                    builder.lessThan(infoProductRoot.get(priceData), priceTo)));
          };
    return productSpecification;
  }

  public static Specification<Product> status(Integer status) {
    if (status != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder)-> {
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          if (status == 1)
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.equal(infoProductRoot.get("itemCurrent"),0)));
          else
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.greaterThan(infoProductRoot.get("itemCurrent"),0)));
        };
      else
        productSpecification = productSpecification.and((root,query,builder)-> {
          Subquery<InfoProduct> queryData = query.subquery(InfoProduct.class);
          Root<InfoProduct> infoProductRoot = queryData.from(InfoProduct.class);
          if (status == 1)
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.equal(infoProductRoot.get("itemCurrent"),0)));
          else
            return root.get("id").in(queryData.select(infoProductRoot.get("infoProduct").get("id"))
                .where(builder.greaterThan(infoProductRoot.get("itemCurrent"),0)));
        });
    return productSpecification;
  }

  public static Specification<Product> sorter(String dataSorter,String typeSorter) {
    if (dataSorter != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          if (dataSorter.equals("ASC"))
            query.orderBy(builder.asc(joinInfoProduct.get(typeSorter)));
          else
            query.orderBy(builder.desc(joinInfoProduct.get(typeSorter)));
          return  joinInfoProduct.get("id").isNotNull();
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          if (dataSorter.equals("ASC"))
            query.orderBy(builder.asc(joinInfoProduct.get(typeSorter)));
          else
            query.orderBy(builder.desc(joinInfoProduct.get(typeSorter)));
          return  joinInfoProduct.get("id").isNotNull();
        });

    return productSpecification;
  }

  public static Specification<Product> search(String keyword) {
    if (keyword != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          return builder.like(joinInfoProduct.join("infoProduct").join("lineProduct").get("nameLineProduct"),
              "%" +keyword+ "%");
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          Join<Product, InfoProduct> joinInfoProduct = root.join(Product_.infoProduct);
          return builder.like(joinInfoProduct.join("infoProduct").join("lineProduct").get("nameLineProduct"),
              "%" +keyword+ "%");
        });
    return productSpecification;
  }

  public static Specification<Product> ram(Long ram) {
    if (ram != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          return builder.equal(root.join("ramProduct").get("id"),ram);
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          return builder.equal(root.join("ramProduct").get("id"),ram);
        });
    return productSpecification;
  }

  public static Specification<Product> rom(Long rom) {
    if (rom != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          return builder.equal(root.join("memoryProduct").get("id"),rom);
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          return builder.equal(root.join("memoryProduct").get("id"),rom);
        });
    return productSpecification;
  }

  public static Specification<Product> color(Long color) {
    if (color != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          return builder.equal(root.join("imageProduct").join("colorProduct").get("id"),color);
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          return builder.equal(root.join("imageProduct").join("colorProduct").get("id"),color);
        });
    return productSpecification;
  }

  public static Specification<Product> category(String category) {
    if (category != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          return builder.equal(root.join("lineProduct").join("groupProduct")
              .join("categoryGroupProduct").get("id"),category);
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          return builder.equal(root.join("lineProduct").join("groupProduct")
              .join("categoryGroupProduct").get("id"),category);
        });
    return productSpecification;
  }

  public static Specification<Product> group(String group) {
    if (group != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          return builder.equal(root.join("lineProduct").join("groupProduct")
              .get("id"),group);
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          return builder.equal(root.join("lineProduct").join("groupProduct")
              .get("id"),group);
        });
    return productSpecification;
  }

  public static Specification<Product> brand(String brand) {
    if (brand != null)
      if (productSpecification == null)
        productSpecification = (root,query,builder) -> {
          return builder.equal(root.join("lineProduct").get("brandProduct").get("id"),brand);
        };
      else
        productSpecification = productSpecification.and((root,query,builder) -> {
          return builder.equal(root.join("lineProduct").get("brandProduct").get("id"),brand);
        });
    return productSpecification;
  }

  public static Specification<Product> timeCreated(String timeCreatedFrom, String timeCreatedTo) {
    if (timeCreatedFrom != null & timeCreatedTo != null) {
      if (productSpecification == null) {
        productSpecification = (root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " 00:00:00"),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " 00:00:00"));
        };
      }
      else {
        productSpecification = productSpecification.and((root,query,builder) -> {
          return builder.and(builder.greaterThanOrEqualTo(root.get("timeCreated").as(String.class),
                          timeCreatedFrom + " 00:00:00"),
              builder.lessThanOrEqualTo(root.get("timeCreated").as(String.class),
                      timeCreatedTo + " 00:00:00"));
        });
      }
    }
    return productSpecification;
  }

}
