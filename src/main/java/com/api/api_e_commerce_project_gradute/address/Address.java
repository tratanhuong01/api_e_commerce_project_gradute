package com.api.api_e_commerce_project_gradute.address;

import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User addressUser;

  @Column
  private String cityProvince;

  @Column
  private String district;

  @Column
  private String wards;

  @Column
  private String details;

  @Column
  private int statusAddress;

  @Column
  private int typeAddress;

  @Column
  private int isDefault;

  public int getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(int isDefault) {
    this.isDefault = isDefault;
  }

  public int getTypeAddress() {
    return typeAddress;
  }

  public void setTypeAddress(int typeAddress) {
    this.typeAddress = typeAddress;
  }

  public User getAddressUser() {
    return addressUser;
  }

  public void setAddressUser(User addressUser) {
    this.addressUser = addressUser;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCityProvince() {
    return cityProvince;
  }

  public void setCityProvince(String cityProvince) {
    this.cityProvince = cityProvince;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getWards() {
    return wards;
  }

  public void setWards(String wards) {
    this.wards = wards;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public int getStatusAddress() {
    return statusAddress;
  }

  public void setStatusAddress(int statusAddress) {
    this.statusAddress = statusAddress;
  }
}
