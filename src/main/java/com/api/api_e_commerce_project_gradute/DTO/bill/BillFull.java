package com.api.api_e_commerce_project_gradute.DTO.bill;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductFull;
import com.api.api_e_commerce_project_gradute.bill.Bill;
import com.api.api_e_commerce_project_gradute.bill_detail.BillDetail;
import com.api.api_e_commerce_project_gradute.bill_review.BillReview;

import java.util.List;

public class BillFull {

  private Bill bill;
  private List<BillDetailFull> billDetailList;
  private BillReview billReview;

  public Bill getBill() {
    return bill;
  }

  public void setBill(Bill bill) {
    this.bill = bill;
  }

  public List<BillDetailFull> getBillDetailList() {
    return billDetailList;
  }

  public void setBillDetailList(List<BillDetailFull> billDetailList) {
    this.billDetailList = billDetailList;
  }

  public BillReview getBillReview() {
    return billReview;
  }

  public void setBillReview(BillReview billReview) {
    this.billReview = billReview;
  }
}
