package com.api.api_e_commerce_project_gradute.cart;

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
import java.util.Optional;

@Service
public class CartService {

  @Autowired
  CartRepository cartRepository;

  @Autowired
  ProductRepository productRepository;

  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }

  public Optional<Cart> getCartById(Long idCart) {
    return cartRepository.findById(idCart);
  }

  public List<CartFull> addCart(Cart cart) {
    cart.setTimeCreated((new Timestamp(new Date().getTime())));
    cartRepository.save(cart);
    return getAllCartByIdUser(cart.getUserCart().getId());
  }

  public List<CartFull> getAllCartByIdUser(String idUser) {
    List<CartFull> cartFullList = new ArrayList<>();
    List<CartMain> cartMainList = cartRepository.getAllCartByIdUser(idUser);
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

  public Cart checkCart(String idUser,String idProduct) {
    return cartRepository.checkCart(idUser, idProduct);
  }

  public List<CartFull> updateCart(int amount,Long idCart,String idUser) {
    cartRepository.updateCart(amount,idCart);
    return getAllCartByIdUser(idUser);
  }

  public List<CartFull> deleteCart(Long idCart,String idUser) {
    cartRepository.deleteById(idCart);
    return getAllCartByIdUser(idUser);
  }

}
