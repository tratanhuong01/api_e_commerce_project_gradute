package com.api.api_e_commerce_project_gradute.DTO.product;

import javax.persistence.*;

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
            @ColumnResult(name = "idColor", type = Long.class),
            @ColumnResult(name = "idMemory", type = Long.class),
            @ColumnResult(name = "idRam", type = Long.class),
            @ColumnResult(name = "isShow", type = Integer.class),
            @ColumnResult(name = "idImage", type = Long.class),
            @ColumnResult(name = "slug", type = String.class),
            @ColumnResult(name = "idBrand" , type = String.class),
            @ColumnResult(name = "describeProduct",type = String.class),
            @ColumnResult(name = "typeProduct",type = Integer.class),
            @ColumnResult(name = "review",type = Integer.class),
            @ColumnResult(name = "itemCurrent",type = Integer.class),
            @ColumnResult(name = "itemSold",type = Integer.class)
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
  Long getIdColor();
  Long getIdMemory();
  Long getIdRam();
  int getIsShow();
  Long getIdImage();
  String getSlug();
  String getIdBrand();
  String getDescribeProduct();
  int getTypeProduct();
  int getReview();
  int getItemCurrent();
  int getItemSold();
}
