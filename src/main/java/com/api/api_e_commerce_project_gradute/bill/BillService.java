package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.bill.BillDetailFull;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import com.api.api_e_commerce_project_gradute.bill_detail.BillDetail;
import com.api.api_e_commerce_project_gradute.bill_detail.BillDetailRepository;
import com.api.api_e_commerce_project_gradute.bill_review.BillReviewRepository;
import com.api.api_e_commerce_project_gradute.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

  @Autowired
  BillRepository billRepository;

  @Autowired
  BillDetailRepository billDetailRepository;

  @Autowired
  BillReviewRepository billReviewRepository;

  @Autowired
  ProductService productService;

  public List<Bill> getAllBills(String id,int type) {
    return billRepository.getBillByIdUserAndTypeAll(id,type);
  }

  public Optional<Bill> getBillById(String idBill) {
    return billRepository.findById(idBill);
  }

  public Bill addBill(Bill bill) {
    return billRepository.save(bill);
  }

  public List<BillFull> getBillByUser(String idUser,int type,int offset, int limit) {
    List<BillFull> billFullList = new ArrayList<>();

    List<Bill> billList = billRepository.getBillByIdUserAndTypeLimit(idUser,type,offset,limit);

    for (Bill bill: billList) {
      BillFull billFull = new BillFull();
      billFull.setBill(bill);
      List<BillDetail> billDetailList = billDetailRepository.getBillDetailByIdBill(bill.getId());
      billFull.setBillDetailList(returnBillDetailFull(billDetailList));
      billFull.setBillReview(billReviewRepository.getBillReviewByIdBill(bill.getId()));
      billFullList.add(billFull);
    }

    return billFullList;
  }

  public List<BillDetailFull> returnBillDetailFull(List<BillDetail> billDetailList) {
    List<BillDetailFull> billDetailFullList = new ArrayList<>();

    for (BillDetail billDetail: billDetailList) {
      BillDetailFull billDetailFull = new BillDetailFull();
      billDetailFull.setBillDetail(billDetail);
      billDetailFull.setProductFull(productService.getProductBySlug(billDetail.getProductDetailBill().getId(),-1));
      billDetailFullList.add(billDetailFull);
    }

    return billDetailFullList;
  }

}
