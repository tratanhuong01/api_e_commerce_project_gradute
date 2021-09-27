package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.brand.Brand;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.ram.Ram;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ProductFull {
  private String id;
  private String idProduct;
  private String idCategoryProduct;
  private String nameCategoryProduct;
  private String idGroupProduct;
  private String nameGroupProduct;
  private String idLineProduct;
  private String nameLineProduct;
  private List<Color> colorList;
  private List<Memory> memoryList;
  private List<Image> imageList;
  private String slug;
  private int priceInput;
  private int priceOutput;
  private int sale;
  private Image image;
  private Color color;
  private Memory memory;
  private Ram ram;
  private Brand brand;
  private String describeProduct;
  private int typeProduct;
  private int review;
  private int itemCurrent;
  private int itemSold;

  public ProductFull(String id,String idProduct, String idCategoryProduct, String nameCategoryProduct, String idGroupProduct,
   String nameGroupProduct, String idLineProduct, String nameLineProduct, List<Color> colorList,
   List<Memory> memoryList, List<Image> imageList, String slug, int priceInput, int priceOutput, int sale,
   Image image,Color color,Memory memory,Ram ram,Brand brand,String describeProduct,int typeProduct,
   int review,int itemCurrent,int itemSold){
    this.id = id;
    this.idProduct = idProduct;
    this.idCategoryProduct = idCategoryProduct;
    this.nameCategoryProduct = nameCategoryProduct;
    this.idGroupProduct = idGroupProduct;
    this.nameGroupProduct = nameGroupProduct;
    this.idLineProduct = idLineProduct;
    this.nameLineProduct = nameLineProduct;
    this.colorList = colorList;
    this.memoryList = memoryList;
    this.imageList = imageList;
    this.slug = slug;
    this.priceInput = priceInput;
    this.priceOutput = priceOutput;
    this.sale = sale;
    this.image = image;
    this.color = color;
    this.memory = memory;
    this.ram = ram;
    this.brand = brand;
    this.describeProduct = describeProduct;
    this.typeProduct = typeProduct;
    this.review = review;
    this.itemCurrent = itemCurrent;
    this.itemSold = itemSold;
  }

}
