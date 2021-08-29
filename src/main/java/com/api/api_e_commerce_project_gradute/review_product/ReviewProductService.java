package com.api.api_e_commerce_project_gradute.review_product;

import com.api.api_e_commerce_project_gradute.DTO.review_product.InfoReviewProduct;
import com.api.api_e_commerce_project_gradute.DTO.review_product.LevelReviewProduct;
import com.api.api_e_commerce_project_gradute.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReviewProductService {

  @Autowired
  ReviewProductRepository reviewProductRepository;

  @Autowired
  ProductRepository productRepository;

  public List<ReviewProduct> getAllReviewProducts() {
    return reviewProductRepository.findAll();
  }

  public InfoReviewProduct getAllInfoReviewProduct(String idProduct) {
    InfoReviewProduct infoReviewProduct = new InfoReviewProduct();
    infoReviewProduct.setSumReview(reviewProductRepository.getAllReviewProductsByIdProduct(idProduct,1).size());
    infoReviewProduct.setSumAll(reviewProductRepository.getAllReviewProductsByIdProduct(idProduct,1).size());
    infoReviewProduct.setOneStar(reviewProductRepository.getSumByIdProductByStar(idProduct,1));
    infoReviewProduct.setTwoStar(reviewProductRepository.getSumByIdProductByStar(idProduct,2));
    infoReviewProduct.setThreeStar(reviewProductRepository.getSumByIdProductByStar(idProduct,3));
    infoReviewProduct.setFourStar(reviewProductRepository.getSumByIdProductByStar(idProduct,4));
    infoReviewProduct.setFiveStar(reviewProductRepository.getSumByIdProductByStar(idProduct,5));
    infoReviewProduct.setImages(reviewProductRepository.getReviewHasImageByIdProduct(idProduct));
    return infoReviewProduct;
  }

  public List<LevelReviewProduct> getAllReviewProductsByIdProduct(String idProduct, int level) {
    List<ReviewProduct> reviewProductList =  reviewProductRepository.getAllReviewProductsByIdProduct(idProduct,level);
    List<LevelReviewProduct> levelReviewProductList = new ArrayList<>();
    for (ReviewProduct reviewProduct:reviewProductList) {
      LevelReviewProduct levelReviewProduct = new LevelReviewProduct();
      levelReviewProduct.setReviewProduct(reviewProduct);
      levelReviewProduct.setReviewProductList(reviewProductRepository.getReviewProductByReply(reviewProduct.getId(),0,2));
      levelReviewProductList.add(levelReviewProduct);
    }
    return levelReviewProductList;
  }

  public List<LevelReviewProduct> getAllReviewProductsByIdProductLimit(String idProduct,int level,int offset,int limit) {
    List<ReviewProduct> reviewProductList =  reviewProductRepository.getAllReviewProductsByIdProductLimit(idProduct,level,offset,limit);
    List<LevelReviewProduct> levelReviewProductList = new ArrayList<>();
    for (ReviewProduct reviewProduct:reviewProductList) {
      LevelReviewProduct levelReviewProduct = new LevelReviewProduct();
      levelReviewProduct.setReviewProduct(reviewProduct);
      levelReviewProduct.setReviewProductList(reviewProductRepository.getReviewProductByReply(reviewProduct.getId(),0,2));
      levelReviewProductList.add(levelReviewProduct);
    }
    return levelReviewProductList;
  }

  public List<ReviewProduct> addReviewProduct(ReviewProduct reviewProduct,String idProduct) {
    reviewProduct.setTimeCreated((new Timestamp(new Date().getTime())));
    reviewProduct.setProductReview(productRepository.getProductById(idProduct));
    reviewProductRepository.save(reviewProduct);
    return reviewProductRepository.getAllReviewProductsByIdProduct(idProduct,1);
  }

  public List<LevelReviewProduct> getReviewProductByStartByIdProduct(String idProduct,int star,int offset,int limit) {
    List<ReviewProduct> reviewProductList = reviewProductRepository.getReviewProductByStarByIdProductLimit(idProduct, star, offset, limit);
    List<LevelReviewProduct> levelReviewProductList = new ArrayList<>();
    for (ReviewProduct reviewProduct:reviewProductList) {
      LevelReviewProduct levelReviewProduct = new LevelReviewProduct();
      levelReviewProduct.setReviewProduct(reviewProduct);
      levelReviewProduct.setReviewProductList(reviewProductRepository.getReviewProductByReply(reviewProduct.getId(),0,2));
      levelReviewProductList.add(levelReviewProduct);
    }
    return levelReviewProductList;
  }

  public int getReviewProductByStartByIdProductAll(String idProduct,int star) {
    return reviewProductRepository.getReviewProductByStarByIdProductAll(idProduct, star);
  }

}
