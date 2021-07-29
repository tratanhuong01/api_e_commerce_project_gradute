package com.api.api_e_commerce_project_gradute.bill_review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillReviewController {

  @Autowired
  BillReviewService billReviewService;

  @CrossOrigin
  @GetMapping("billReviews")
  public List<BillReview> getAllBillReviews() {
    return billReviewService.getAllBillReviews();
  }

  @CrossOrigin
  @GetMapping("billReviews/{idBillReview}")
  public BillReview getBillReviewById(@PathVariable Long idBillReview) {
    return billReviewService.getBillReviewById(idBillReview);
  }

  @CrossOrigin
  @PostMapping("billReviews")
  public BillReview addBillReviews(@RequestBody BillReview billReview) {
    return billReviewService.addBillReview(billReview);
  }

  @CrossOrigin
  @PutMapping("billReviews")
  public BillReview updateBillReviews(@RequestBody BillReview billReview) {
    return billReviewService.addBillReview(billReview);
  }

}
