package com.api.api_e_commerce_project_gradute.review_product;

import com.api.api_e_commerce_project_gradute.DTO.review_product.InfoReviewProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewProductController {

  @Autowired
  ReviewProductService reviewProductService;

  @CrossOrigin
  @GetMapping("reviewProductsAll/{idProduct}")
  public InfoReviewProduct getAllReviewProducts(@PathVariable String idProduct) {
    return reviewProductService.getAllInfoReviewProduct(idProduct);
  }

//  @CrossOrigin
//  @GetMapping("reviewProductByStar/{idProduct}")
//  public List<ReviewProduct> getReviewProductByStartByIdProduct(@PathVariable String idProduct) {
//    return reviewProductService.
//  }

  @CrossOrigin
  @GetMapping("reviewProducts/{idProduct}/{offset}/{limit}")
  public List<ReviewProduct> getAllReviewProductsLimitByIdProduct(@PathVariable String idProduct,@PathVariable int offset,
                                                                  @PathVariable int limit) {
    return reviewProductService.getAllReviewProductsByIdProductLimit(idProduct,1,offset,limit);
  }

  @CrossOrigin
  @PostMapping("reviewProducts")
  public List<ReviewProduct> addReviewProduct(@RequestBody ReviewProduct reviewProduct) {
    return reviewProductService.addReviewProduct(reviewProduct);
  }

}
