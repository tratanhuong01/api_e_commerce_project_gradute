package com.api.api_e_commerce_project_gradute.DTO.bill;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductFull;
import com.api.api_e_commerce_project_gradute.bill_detail.BillDetail;

public class BillDetailFull {
  private BillDetail billDetail;
  private ProductFull productFull;

  public BillDetail getBillDetail() {
    return billDetail;
  }

  public void setBillDetail(BillDetail billDetail) {
    this.billDetail = billDetail;
  }

  public ProductFull getProductFull() {
    return productFull;
  }

  public void setProductFull(ProductFull productFull) {
    this.productFull = productFull;
  }
}
