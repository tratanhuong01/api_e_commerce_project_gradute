package com.api.api_e_commerce_project_gradute.DTO.cart;

import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.memory.Memory;

public class CartFull {
  private String idCart;
  private String idProduct;
  private String idUser;
  private String firstName;
  private String lastName;
  private String idLineProduct;
  private String nameLineProduct;
  private int priceInput;
  private int priceOutput;
  private int sale;
  private Color color;
  private Memory memory;
  private Image image;
  private String slug;
  private String brand;
  private int amount;

  public CartFull(String idCart, String idProduct, String idUser, String firstName, String lastName, String idLineProduct,
  String nameLineProduct, int priceInput, int priceOutput, int sale, Color color, Memory memory, Image image,
  String slug, String brand,int amount) {
    this.idCart = idCart;
    this.idProduct = idProduct;
    this.idUser = idUser;
    this.firstName = firstName;
    this.lastName = lastName;
    this.idLineProduct = idLineProduct;
    this.nameLineProduct = nameLineProduct;
    this.priceInput = priceInput;
    this.priceOutput = priceOutput;
    this.sale = sale;
    this.color = color;
    this.memory = memory;
    this.image = image;
    this.slug = slug;
    this.brand = brand;
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getIdCart() {
    return idCart;
  }

  public void setIdCart(String idCart) {
    this.idCart = idCart;
  }

  public String getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(String idProduct) {
    this.idProduct = idProduct;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Memory getMemory() {
    return memory;
  }

  public void setMemory(Memory memory) {
    this.memory = memory;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }
}
