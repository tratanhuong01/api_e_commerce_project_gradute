package com.api.api_e_commerce_project_gradute.review_product;

import com.api.api_e_commerce_project_gradute.DTO.review_product.InfoReviewProduct;
import com.api.api_e_commerce_project_gradute.DTO.review_product.LevelReviewProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ReviewProductController {

  @Autowired
  ReviewProductService reviewProductService;

  @GetMapping("reviewProductsAll/{idProduct}")
  public InfoReviewProduct getAllReviewProducts(@PathVariable String idProduct) {
    return reviewProductService.getAllInfoReviewProduct(idProduct);
  }

  @GetMapping("reviewProductByStar/{idProduct}/{star}/{offset}/{limit}")
  public List<LevelReviewProduct> getReviewProductByStartByIdProduct(@PathVariable String idProduct,
  @PathVariable int star,@PathVariable int offset,@PathVariable int limit) {
    return reviewProductService.getReviewProductByStartByIdProduct(idProduct, star, offset, limit);
  }

  @GetMapping("reviewProductByStarAll/{idProduct}/{star}")
  public List<LevelReviewProduct> getReviewProductByStartByIdProductAll(@PathVariable String idProduct,
  @PathVariable int star) {
    return reviewProductService.getReviewProductByStartByIdProductAll(idProduct, star);
  }

  @GetMapping("reviewProducts/{idProduct}/{offset}/{limit}")
  public List<LevelReviewProduct> getAllReviewProductsLimitByIdProduct(@PathVariable String idProduct, @PathVariable int offset,
                                                                       @PathVariable int limit) {
    return reviewProductService.getAllReviewProductsByIdProductLimit(idProduct,1,offset,limit);
  }

  @PostMapping("reviewProducts/{idProduct}")
  public List<ReviewProduct> addReviewProduct(@RequestBody ReviewProduct reviewProduct,
                                              @PathVariable String idProduct) {
    return reviewProductService.addReviewProduct(reviewProduct,idProduct);
  }

}
