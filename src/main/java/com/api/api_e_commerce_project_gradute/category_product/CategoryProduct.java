package com.api.api_e_commerce_project_gradute.category_product;

import com.api.api_e_commerce_project_gradute.group_product.GroupProduct;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category_product")
public class CategoryProduct {

  @Id
  private String id;

  @OneToMany(mappedBy = "categoryGroupProduct")
  private Set<GroupProduct> categoryGroupProduct = new HashSet<>();

  @Column
  private String nameCategoryProduct;

  @Column
  private String slugCategoryProduct;

  @Column
  private String icon;

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getSlugCategoryProduct() {
    return slugCategoryProduct;
  }

  public void setSlugCategoryProduct(String slugCategoryProduct) {
    this.slugCategoryProduct = slugCategoryProduct;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNameCategoryProduct() {
    return nameCategoryProduct;
  }

  public void setNameCategoryProduct(String nameCategoryProduct) {
    this.nameCategoryProduct = nameCategoryProduct;
  }

}
