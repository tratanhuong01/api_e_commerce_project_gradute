package com.api.api_e_commerce_project_gradute.wish_list;

import com.api.api_e_commerce_project_gradute.DTO.cart.CartFull;
import com.api.api_e_commerce_project_gradute.DTO.cart.CartMain;
import com.api.api_e_commerce_project_gradute.color.Color;
import com.api.api_e_commerce_project_gradute.image.Image;
import com.api.api_e_commerce_project_gradute.memory.Memory;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WishListService {

  @Autowired
  WishListRepository wishListRepository;

  @Autowired
  ProductRepository productRepository;

  public List<WishList> getWistListByIdUser(String idUser) {
    return wishListRepository.getWishListByIdUser(idUser);
  }
  public List<CartFull> getAllWishListByIdUser(String idUser) {
    List<CartFull> cartFullList = new ArrayList<>();
    List<CartMain> cartMainList = wishListRepository.getAllWishListByIdUser(idUser);
    for (CartMain cartMain: cartMainList) {
      Product product = productRepository.getProductById(cartMain.getIdProduct());
      Color color = product.getImageProduct().getColorProduct();
      Image image = product.getImageProduct();
      Memory memory = product.getMemoryProduct();
      CartFull cartFull = new CartFull(cartMain.getIdCart(),cartMain.getIdProduct(),cartMain.getIdUser(),cartMain.getFirstName(),
              cartMain.getLastName(),cartMain.getIdLineProduct(),cartMain.getNameLineProduct(),cartMain.getPriceInput(),cartMain.getPriceOutput(),
              cartMain.getSale(),color, memory,image,cartMain.getSlug(),cartMain.getBrand(),cartMain.getAmount());
      cartFullList.add(cartFull);
    }
    return cartFullList;
  }

  public List<CartFull> addWishList(WishList wishList) {
    wishList.setTimeCreated((new Timestamp(new Date().getTime())));
     wishListRepository.save(wishList);
     return getAllWishListByIdUser(wishList.getWishListUser().getId());
  }

  public List<CartFull> deleteWishList(Long idWishList,String idUser) {
    wishListRepository.deleteById(idWishList);
    return getAllWishListByIdUser(idUser);
  }

  public WishList checkWishList(String idUser,String idProduct) {
    return wishListRepository.checkWishList(idUser,idProduct);
  }

}
