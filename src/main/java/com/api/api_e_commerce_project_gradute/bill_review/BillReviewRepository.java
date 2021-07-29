package com.api.api_e_commerce_project_gradute.bill_review;

import com.api.api_e_commerce_project_gradute.bill_review.BillReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillReviewRepository extends JpaRepository<BillReview,Long> {
}
