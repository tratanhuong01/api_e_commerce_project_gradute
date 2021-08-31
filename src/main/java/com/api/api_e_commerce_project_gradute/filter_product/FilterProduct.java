package com.api.api_e_commerce_project_gradute.filter_product;

import com.api.api_e_commerce_project_gradute.attribute.Attribute;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import com.api.api_e_commerce_project_gradute.function_product.FunctionProduct;
import com.api.api_e_commerce_project_gradute.group_filter_product.GroupFilterProduct;
import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;

import javax.persistence.*;

@Entity
@Table(name = "filter_product")
public class FilterProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_group_filter_product")
  private GroupFilterProduct groupFilterProduct;

  @ManyToOne
  @JoinColumn(name = "id_function_product")
  private FunctionProduct functionProductFilter;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GroupFilterProduct getGroupFilterProduct() {
    return groupFilterProduct;
  }

  public void setGroupFilterProduct(GroupFilterProduct groupFilterProduct) {
    this.groupFilterProduct = groupFilterProduct;
  }

  public FunctionProduct getFunctionProductFilter() {
    return functionProductFilter;
  }

  public void setFunctionProductFilter(FunctionProduct functionProductFilter) {
    this.functionProductFilter = functionProductFilter;
  }
}
