package com.api.api_e_commerce_project_gradute.bank;

import com.api.api_e_commerce_project_gradute.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bank")
public class Bank {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String codeBank;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User userBank;

  @Column
  private String nameBank;

  @Column
  private String numberBank;

  @Column
  private String branchBank;

  @Column
  private Date dateEnd;

  @Column
  private Date dateStart;

  @Column
  private int statusBank;

  @Column
  private int typeBank;

  public int getTypeBank() {
    return typeBank;
  }

  public void setTypeBank(int typeBank) {
    this.typeBank = typeBank;
  }

  public String getCodeBank() {
    return codeBank;
  }

  public void setCodeBank(String codeBank) {
    this.codeBank = codeBank;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUserBank() {
    return userBank;
  }

  public void setUserBank(User userBank) {
    this.userBank = userBank;
  }

  public String getNameBank() {
    return nameBank;
  }

  public void setNameBank(String nameBank) {
    this.nameBank = nameBank;
  }

  public String getNumberBank() {
    return numberBank;
  }

  public void setNumberBank(String numberBank) {
    this.numberBank = numberBank;
  }

  public String getBranchBank() {
    return branchBank;
  }

  public void setBranchBank(String branchBank) {
    this.branchBank = branchBank;
  }

  public Date getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(Date dateEnd) {
    this.dateEnd = dateEnd;
  }

  public Date getDateStart() {
    return dateStart;
  }

  public void setDateStart(Date dateStart) {
    dateStart = dateStart;
  }

  public int getStatusBank() {
    return statusBank;
  }

  public void setStatusBank(int statusBank) {
    this.statusBank = statusBank;
  }
}
