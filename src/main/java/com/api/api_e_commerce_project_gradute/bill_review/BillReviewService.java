package com.api.api_e_commerce_project_gradute.bill_review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillReviewService {

  @Autowired
  BillReviewRepository billReviewRepository;

  public List<BillReview> getAllBillReviews() {
    return billReviewRepository.findAll();
  }

  public BillReview getBillReviewById(Long idBillReview) {
    return billReviewRepository.getById(idBillReview);
  }

  public BillReview addBillReview(BillReview billReview) {
    return billReviewRepository.save(billReview);
  }

}
