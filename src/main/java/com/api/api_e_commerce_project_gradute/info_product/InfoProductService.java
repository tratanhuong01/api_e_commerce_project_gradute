package com.api.api_e_commerce_project_gradute.info_product;

import com.api.api_e_commerce_project_gradute.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoProductService {

  @Autowired
  InfoProductRepository infoProductRepository;

  @Autowired
  ProductRepository productRepository;

  public InfoProduct addInfoProduct(InfoProduct infoProduct) {
    return infoProductRepository.save(infoProduct);
  }

  public InfoProduct addInfoProduct(InfoProduct infoProduct,String idProduct) {
    infoProduct.setInfoProduct(productRepository.getProductById(idProduct));
    return infoProductRepository.save(infoProduct);
  }

  public List<InfoProduct> getAllInfoProduct() {
    return infoProductRepository.findAll();
  }

  public int getItemCurrentProductById(String idProduct) {
    return infoProductRepository.getItemCurrentProductById(idProduct);
  }

  public int updateItemCurrentAndItemSolid(int amount,String idProduct) {
    return infoProductRepository.updateItemProductCurrentAndBold(amount, idProduct);
  }

  public int updateReviewProduct(int review,String idProduct) {
    return infoProductRepository.updateReviewProduct(review, idProduct);
  }

}
