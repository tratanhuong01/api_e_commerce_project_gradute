package com.api.api_e_commerce_project_gradute.bill_review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class BillReviewController {

  @Autowired
  BillReviewService billReviewService;

  @GetMapping("billReviews")
  public List<BillReview> getAllBillReviews() {
    return billReviewService.getAllBillReviews();
  }

  @GetMapping("billReviews/{idBillReview}")
  public Optional<BillReview> getBillReviewById(@PathVariable Long idBillReview) {
    return billReviewService.getBillReviewById(idBillReview);
  }

  @PostMapping("billReviews")
  public BillReview addBillReviews(@RequestBody BillReview billReview) {
    return billReviewService.addBillReview(billReview);
  }

  @PutMapping("billReviews")
  public BillReview updateBillReviews(@RequestBody BillReview billReview) {
    return billReviewService.addBillReview(billReview);
  }

}
