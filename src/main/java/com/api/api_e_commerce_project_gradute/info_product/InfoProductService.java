package com.api.api_e_commerce_project_gradute.info_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoProductService {

  @Autowired
  InfoProductRepository infoProductRepository;

  public InfoProduct addInfoProduct(InfoProduct infoProduct) {
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

}
