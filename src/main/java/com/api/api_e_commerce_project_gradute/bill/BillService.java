package com.api.api_e_commerce_project_gradute.bill;

import com.api.api_e_commerce_project_gradute.DTO.DashboardHeader;
import com.api.api_e_commerce_project_gradute.DTO.NumberByMonth;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillDetailFull;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillFull;
import com.api.api_e_commerce_project_gradute.DTO.bill.BillInfoCurrent;
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
import java.util.*;

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

  public List<NumberByMonth> getBillSixMonthCurrent() {
    List<NumberByMonth> numberByMonthList  = new ArrayList<>();
    Date dateCurrent = new Date();
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    cal.setTime(dateCurrent);
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    for (int i = 0; i < 6; i++) {
      NumberByMonth numberByMonth = new NumberByMonth();
      numberByMonth.setNumber(billRepository.getBillSixMonthCurrent(6 - i));
      numberByMonth.setMonth("Tháng " + (month - 5 + i) + "/" + year);
      numberByMonthList.add(numberByMonth);
    }
    return numberByMonthList;
  }

  public List<NumberByMonth> getProductSixMonthCurrent() {
    List<NumberByMonth> numberByMonthList  = new ArrayList<>();
    Date dateCurrent = new Date();
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    cal.setTime(dateCurrent);
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    for (int i = 0; i < 6; i++) {
      Integer number = billRepository.getProductSixMonthCurrent(6 - i);
      NumberByMonth numberByMonth = new NumberByMonth();
      numberByMonth.setNumber(number == null ? 0 : number);
      numberByMonth.setMonth("Tháng " + (month - 5 + i) + "/" + year);
      numberByMonthList.add(numberByMonth);
    }
    return numberByMonthList;
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
  public Bill updateBill(Bill bill) {
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

  public DashboardHeader getDashboardHeader(String dateFrom,String dateTo,Integer day) {
    Integer totalProfitMain = 0;
    Integer totalMoney = 0;
    DashboardHeader dashboardHeader = new DashboardHeader();
    Integer billNumber = 0;
    Integer userSum = 0;
    Integer totalRevenue = 0;
    Integer sell = 0;
    System.out.println("Day " + day);
    if (day != null) {
      switch (day) {
        case 0 :
          totalProfitMain = billRepository.getSumDetailBillTotalProfitToday();
          totalMoney = billRepository.getTotalMoneyBillToday();
          billNumber = billRepository.getBillToday();
          userSum = userRepository.getUserRegisterToDay();
          totalRevenue = billRepository.getTotalMoneyBillToday();
          sell = billRepository.getProductSellToday();
          break;
        case 1 :
          totalProfitMain = billRepository.getSumDetailBillTotalProfitYesterday();
          totalMoney = billRepository.getTotalMoneyBillYesterday();
          billNumber = billRepository.getBillYesterday();
          userSum = userRepository.getUserRegisterYesterday();
          totalRevenue = billRepository.getTotalMoneyBillYesterday();
          sell = billRepository.getProductSellYesterday();
          break;
        case 7 :
          totalProfitMain = billRepository.getSumDetailBillTotalProfitSevenDay();
          totalMoney = billRepository.getTotalMoneyBillSevenDay();
          billNumber = billRepository.getBillSevenDay();
          userSum = userRepository.getUserRegisterSeven();
          totalRevenue = billRepository.getTotalMoneyBillSevenDay();
          sell = billRepository.getProductSellSevenDay();
          break;
        case 30 :
          totalProfitMain = billRepository.getSumDetailBillTotalProfitMonthCurrent();
          totalMoney = billRepository.getTotalMoneyBillMonthCurrent();
          billNumber = billRepository.getBillMonthCurrents();
          userSum = userRepository.getUserRegisterMonthCurrent();
          totalRevenue = billRepository.getTotalMoneyBillMonthCurrent();
          sell = billRepository.getProductSellMonthCurrent();
          break;
        case 60 :
          totalProfitMain = billRepository.getSumDetailBillTotalProfitMonthPrevious();
          totalMoney = billRepository.getTotalMoneyBillMonthPrevious();
          billNumber = billRepository.getBillMonthPrevious();
          userSum = userRepository.getUserRegisterMonthPrevious();
          totalRevenue = billRepository.getTotalMoneyBillMonthPrevious();
          sell = billRepository.getProductSellMonthPrevious();
          break;
      }
    }
    else {
      totalProfitMain = billRepository.getSumDetailBillTotalProfitFromTo(dateTo,dateFrom);
      totalMoney = billRepository.getTotalMoneyBillFromTo(dateTo,dateFrom);
      billNumber = billRepository.getBillMonthFromTo(dateTo,dateFrom);
      userSum = userRepository.getUserRegisterFromTo(dateTo,dateFrom);
      totalRevenue = billRepository.getTotalMoneyBillFromTo(dateTo,dateFrom);
      sell = billRepository.getProductSellFromTo(dateTo,dateFrom);
    }
    Integer totalProfit =  (totalMoney == null ? 0 : totalMoney) - (totalProfitMain == null ? 0 : totalProfitMain);
    dashboardHeader.setTotalBill(billNumber == null ? 0 : billNumber);
    dashboardHeader.setTotalProfit(totalProfit);
    dashboardHeader.setTotalRevenue(totalRevenue == null ? 0 : totalRevenue);
    dashboardHeader.setTotalRegister(userSum == null ? 0 : userSum);
    dashboardHeader.setTotalSold(sell == null ? 0 : sell);
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
