package com.api.api_e_commerce_project_gradute.DTO.product;

import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.memory.Memory;

import java.util.List;

public class ProductFull {
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
  private String image;
  private String color;
  private String memory;
  private String brand;
  public ProductFull(String idProduct, String idCategoryProduct, String nameCategoryProduct, String idGroupProduct,
 String nameGroupProduct, String idLineProduct, String nameLineProduct, List<Color> colorList,
 List<Memory> memoryList, List<Image> imageList, String slug, int priceInput, int priceOutput, int sale,
 String image,String color,String memory,String brand){
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
    this.brand = brand;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getMemory() {
    return memory;
  }

  public void setMemory(String memory) {
    this.memory = memory;
  }

  public String getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(String idProduct) {
    this.idProduct = idProduct;
  }

  public String getIdCategoryProduct() {
    return idCategoryProduct;
  }

  public void setIdCategoryProduct(String idCategoryProduct) {
    this.idCategoryProduct = idCategoryProduct;
  }

  public String getNameCategoryProduct() {
    return nameCategoryProduct;
  }

  public void setNameCategoryProduct(String nameCategoryProduct) {
    this.nameCategoryProduct = nameCategoryProduct;
  }

  public String getIdGroupProduct() {
    return idGroupProduct;
  }

  public void setIdGroupProduct(String idGroupProduct) {
    this.idGroupProduct = idGroupProduct;
  }

  public String getNameGroupProduct() {
    return nameGroupProduct;
  }

  public void setNameGroupProduct(String nameGroupProduct) {
    this.nameGroupProduct = nameGroupProduct;
  }

  public String getIdLineProduct() {
    return idLineProduct;
  }

  public void setIdLineProduct(String idLineProduct) {
    this.idLineProduct = idLineProduct;
  }

  public String getNameLineProduct() {
    return nameLineProduct;
  }

  public void setNameLineProduct(String nameLineProduct) {
    this.nameLineProduct = nameLineProduct;
  }

  public List<Color> getColorList() {
    return colorList;
  }

  public void setColorList(List<Color> colorList) {
    this.colorList = colorList;
  }

  public List<Memory> getMemoryList() {
    return memoryList;
  }

  public void setMemoryList(List<Memory> memoryList) {
    this.memoryList = memoryList;
  }

  public List<Image> getImageList() {
    return imageList;
  }

  public void setImageList(List<Image> imageList) {
    this.imageList = imageList;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public int getPriceInput() {
    return priceInput;
  }

  public void setPriceInput(int priceInput) {
    this.priceInput = priceInput;
  }

  public int getPriceOutput() {
    return priceOutput;
  }

  public void setPriceOutput(int priceOutput) {
    this.priceOutput = priceOutput;
  }

  public int getSale() {
    return sale;
  }

  public void setSale(int sale) {
    this.sale = sale;
  }
}
