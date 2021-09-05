package com.api.api_e_commerce_project_gradute.DTO.cart;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "customDataMapping1",
    classes = @ConstructorResult(
        targetClass = com.api.api_e_commerce_project_gradute.DTO.cart.CartMain.class,
        columns = {
            @ColumnResult(name = "idCart", type = String.class),
            @ColumnResult(name = "idProduct" , type = String.class),
            @ColumnResult(name = "idUser", type = String.class),
            @ColumnResult(name = "firstName", type = String.class),
            @ColumnResult(name = "lastName", type = String.class),
            @ColumnResult(name = "idLineProduct", type = String.class),
            @ColumnResult(name = "nameLineProduct", type = String.class),
            @ColumnResult(name = "priceInput", type = Integer.class),
            @ColumnResult(name = "priceOutput", type = Integer.class),
            @ColumnResult(name = "sale", type = Integer.class),
            @ColumnResult(name = "color", type = String.class),
            @ColumnResult(name = "memory", type = String.class),
            @ColumnResult(name = "image", type = Long.class),
            @ColumnResult(name = "slug", type = String.class),
            @ColumnResult(name = "brand" , type = String.class),
            @ColumnResult(name = "amount",type = Integer.class)
        }
    )
)

@NamedNativeQuery(name = "", query = "",
    resultSetMapping = "customDataMapping1")

public interface CartMain {
  String getIdCart();
  String getIdProduct();
  String getIdUser();
  String getFirstName();
  String getLastName();
  String getIdLineProduct();
  String getNameLineProduct();
  int getPriceInput();
  int getPriceOutput();
  int getSale();
  Long getColor();
  Long getMemory();
  Long getImage();
  String getSlug();
  String getBrand();
  int getAmount();
}

