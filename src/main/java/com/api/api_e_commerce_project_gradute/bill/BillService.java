package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.DashboardHeader;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillDetailFull;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import com.api.api_e_commerce_project_gradute.DTO.specification.bill.BillCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.bill.BillSpecifications;
import com.api.api_e_commerce_project_gradute.bill_detail.BillDetail;
import com.api.api_e_commerce_project_gradute.bill_detail.BillDetailRepository;
import com.api.api_e_commerce_project_gradute.bill_review.BillReviewRepository;
import com.api.api_e_commerce_project_gradute.product.ProductService;
import com.api.api_e_commerce_project_gradute.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

  @Autowired
  BillRepository billRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  BillDetailRepository billDetailRepository;

  @Autowired
  BillReviewRepository billReviewRepository;

  @Autowired
  ProductService productService;

  //admin

  public List<Bill> getAllBillAdminAllByStatus(int status) {
    return billRepository.getBillAllByStatus(status);
  }

  public List<Bill> getAllBillAdminAllByStatusLimit(int status,int offset, int limit) {
    return billRepository.getBillAllByStatusLimit(status,offset,limit);
  }

  public List<Bill> getAllBillAdminAll() {
    return billRepository.getBillAll();
  }

  public List<Bill> getAllBillAdminAllLimit(int offset, int limit) {
    return billRepository.getBillAllLimit(offset, limit);
  }

  //user

  public List<Bill> getAllBillsMain() {
    return billRepository.findAll();
  }

  public List<Bill> getAllBillsMainLimit(int offset,int limit) {
    return billRepository.getBillByIdUserLimitAdmin(offset, limit);
  }

  public List<Bill> getAllBills(String id,int type) {
    if (type == -2)
      return billRepository.getBillByIdUserAll(id);
    else
      return billRepository.getBillByIdUserAndTypeAll(id,type);
  }

  public Optional<Bill> getBillById(String idBill) {
    return billRepository.findById(idBill);
  }

  public Bill addBill(Bill bill) {
    bill.setTimeCreated((new Timestamp(new Date().getTime())));
    return billRepository.save(bill);
  }

  public List<BillFull> getBillByUser(String idUser,int type,int offset, int limit) {
    List<BillFull> billFullList = new ArrayList<>();
    List<Bill> billList = new ArrayList<>();
    if (type != -2)
      billList = billRepository.getBillByIdUserAndTypeLimit(idUser,type,offset,limit);
    else
      billList = billRepository.getBillByIdUserLimit(idUser,offset,limit);

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

  public int updateStatusBill(Long idBill,int status) {
    return billRepository.updateStatusBill(status,idBill);
  }

  public BillFull getBillById(Long id) {
    BillFull billFull = new BillFull();
    Bill bill = billRepository.getBillById(id);
    billFull.setBill(bill);
    List<BillDetail> billDetailList = billDetailRepository.getBillDetailByIdBill(bill.getId());
    billFull.setBillDetailList(returnBillDetailFull(billDetailList));
    billFull.setBillReview(billReviewRepository.getBillReviewByIdBill(bill.getId()));
    return billFull;
  }

  public List<BillFull> searchBill(String keyword,String idUser,int offset, int limit,int type) {
    List<BillFull> billFullList = new ArrayList<>();
    List<Bill> billList = new ArrayList<>();

    if (type == -2)
      billList = billRepository.searchBill(keyword, idUser);
    else
      billList = billRepository.searchBillLimit(keyword,idUser,offset,limit);

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

  public DashboardHeader getDashboardHeader() {
    DashboardHeader dashboardHeader = new DashboardHeader();
    dashboardHeader.setTotalBill(billRepository.getBillToday() == null ? 0 : Integer.parseInt(billRepository.getBillToday()));
    dashboardHeader.setTotalProfit(billRepository.getTotalProfitToday() == null ? 0 : Integer.parseInt(billRepository.getTotalProfitToday()));
    dashboardHeader.setTotalRegister(userRepository.getUserRegisterToDay());
    dashboardHeader.setTotalRevenue(billRepository.getTotalMoneyBillToday() == null ? 0 : Integer.parseInt(billRepository.getTotalMoneyBillToday()));
    dashboardHeader.setTotalSold(billRepository.getProductSellToday() == null ? 0 : Integer.parseInt(billRepository.getProductSellToday()));
    return dashboardHeader;
  }

  public Integer getBillFiltersAll(BillCriteria billCriteria) {
    Specification<Bill> billSpecification = BillSpecifications.createBillSpecification(billCriteria);
    return billRepository.findAll(billSpecification).size();
  }

  public List<Bill> getBillFiltersLimit(BillCriteria billCriteria) {
    Specification<Bill> billSpecification = BillSpecifications.createBillSpecification(billCriteria);
    Pageable pageable = PageRequest.of(billCriteria.getOffset(),billCriteria.getLimit());
    Page<Bill> billPage = billRepository.findAll(billSpecification,pageable);
    return billPage.getContent();
  }

}
