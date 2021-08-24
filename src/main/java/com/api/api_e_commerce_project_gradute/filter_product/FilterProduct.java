package com.api.api_e_commerce_project_gradute.filter_product;

import com.api.api_e_commerce_project_gradute.attribute.Attribute;
import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;

import javax.persistence.*;

@Entity
@Table(name = "filter_product")
public class FilterProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_category_product")
  private CategoryProduct categoryProductFilter;

  @ManyToOne
  @JoinColumn(name = "id_attribute")
  private Attribute attributeFilterProduct;

  @Column
  private int status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CategoryProduct getCategoryProductFilter() {
    return categoryProductFilter;
  }

  public void setCategoryProductFilter(CategoryProduct categoryProductFilter) {
    this.categoryProductFilter = categoryProductFilter;
  }

  public Attribute getAttributeFilterProduct() {
    return attributeFilterProduct;
  }

  public void setAttributeFilterProduct(Attribute attributeFilterProduct) {
    this.attributeFilterProduct = attributeFilterProduct;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
