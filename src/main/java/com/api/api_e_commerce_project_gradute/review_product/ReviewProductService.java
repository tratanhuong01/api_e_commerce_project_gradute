package com.api.api_e_commerce_project_gradute.review_product;

import com.api.api_e_commerce_project_gradute.DTO.review_product.InfoReviewProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewProductService {

  @Autowired
  ReviewProductRepository reviewProductRepository;

  public List<ReviewProduct> getAllReviewProducts() {
    return reviewProductRepository.findAll();
  }

  public InfoReviewProduct getAllInfoReviewProduct(String idProduct) {
    InfoReviewProduct infoReviewProduct = new InfoReviewProduct();
    infoReviewProduct.setSumReview(reviewProductRepository.getAllReviewProductsByIdProduct(idProduct,1).size());
    infoReviewProduct.setOneStar(reviewProductRepository.getSumByIdProductByStar(idProduct,1));
    infoReviewProduct.setTwoStar(reviewProductRepository.getSumByIdProductByStar(idProduct,2));
    infoReviewProduct.setThreeStar(reviewProductRepository.getSumByIdProductByStar(idProduct,3));
    infoReviewProduct.setFourStar(reviewProductRepository.getSumByIdProductByStar(idProduct,4));
    infoReviewProduct.setFiveStar(reviewProductRepository.getSumByIdProductByStar(idProduct,5));
    infoReviewProduct.setImages(reviewProductRepository.getReviewHasImageByIdProduct(idProduct));
    return infoReviewProduct;
  }

  public List<ReviewProduct> getAllReviewProductsByIdProduct(String idProduct,int level) {
    return reviewProductRepository.getAllReviewProductsByIdProduct(idProduct,level);
  }

  public List<ReviewProduct> getAllReviewProductsByIdProductLimit(String idProduct,int level,int offset,int limit) {
    return reviewProductRepository.getAllReviewProductsByIdProductLimit(idProduct,level,offset,limit);
  }

  public List<ReviewProduct> addReviewProduct(ReviewProduct reviewProduct) {
    reviewProductRepository.save(reviewProduct);
    return reviewProductRepository.findAll();
  }

}
