package com.api.api_e_commerce_project_gradute.bill_review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillReviewService {

  @Autowired
  BillReviewRepository billReviewRepository;

  public List<BillReview> getAllBillReviews() {
    return billReviewRepository.findAll();
  }

  public Optional<BillReview> getBillReviewById(Long idBillReview) {
    return billReviewRepository.findById(idBillReview);
  }

  public BillReview addBillReview(BillReview billReview) {
    return billReviewRepository.save(billReview);
  }

}
