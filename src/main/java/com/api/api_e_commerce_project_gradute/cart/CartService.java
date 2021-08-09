package com.api.api_e_commerce_project_gradute.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

  @Autowired
  CartRepository cartRepository;

  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }

  public Optional<Cart> getCartById(Long idCart) {
    return cartRepository.findById(idCart);
  }

  public Cart addCart(Cart cart) {
    return cartRepository.save(cart);
  }

}
