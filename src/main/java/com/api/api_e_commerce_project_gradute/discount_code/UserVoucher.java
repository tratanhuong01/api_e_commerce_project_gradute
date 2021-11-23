package com.api.api_e_commerce_project_gradute.discount_code;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "customDataMapping",
        classes = @ConstructorResult(
                targetClass = com.api.api_e_commerce_project_gradute.DTO.product.ProductMain.class,
                columns = {
                        @ColumnResult(name = "idUser", type = String.class),
                        @ColumnResult(name = "sumItem", type = String.class),
                }
        )
)

@NamedNativeQuery(name = "getMessagesByGroupMessage", query = "",
        resultSetMapping = "customDataMapping")

public interface UserVoucher {
    String getIdUser();
    String getSumItem();
}
