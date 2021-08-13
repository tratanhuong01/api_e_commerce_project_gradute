package com.api.api_e_commerce_project_gradute.DTO.product;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "customDataMapping",
    classes = @ConstructorResult(
        targetClass = ProductMain.class,
        columns = {
            @ColumnResult(name = "idProduct", type = String.class),
            @ColumnResult(name = "idCategoryProduct", type = String.class),
            @ColumnResult(name = "nameCategoryProduct", type = String.class),
            @ColumnResult(name = "idGroupProduct", type = String.class),
            @ColumnResult(name = "nameProductProduct", type = String.class),
            @ColumnResult(name = "idLineProduct", type = String.class),
            @ColumnResult(name = "nameLineProduct", type = String.class),
            @ColumnResult(name = "priceInput", type = Integer.class),
            @ColumnResult(name = "priceOutput", type = Integer.class),
            @ColumnResult(name = "sale", type = Integer.class),
            @ColumnResult(name = "idColor", type = String.class),
            @ColumnResult(name = "idMemory", type = String.class),
            @ColumnResult(name = "isShow", type = Integer.class),
            @ColumnResult(name = "idImage", type = Long.class),
            @ColumnResult(name = "slug", type = String.class),
            @ColumnResult(name = "idBrand" , type = String.class),
            @ColumnResult(name = "describeProduct",type = String.class)
        }
    )
)

@NamedNativeQuery(name = "getMessagesByGroupMessage", query = "",
    resultSetMapping = "customDataMapping")

public interface ProductMain {
  String getIdProduct();
  String getIdCategoryProduct();
  String getNameCategoryProduct();
  String getIdGroupProduct();
  String getNameGroupProduct();
  String getIdLineProduct();
  String getNameLineProduct();
  int getPriceInput();
  int getPriceOutput();
  int getSale();
  String getIdColor();
  String getIdMemory();
  int getIsShow();
  Long getIdImage();
  String getSlug();
  String getIdBrand();
  String getDescribeProduct();
}
