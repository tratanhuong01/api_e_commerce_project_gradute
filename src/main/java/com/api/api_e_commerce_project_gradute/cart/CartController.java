package com.api.api_e_commerce_project_gradute.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

  @Autowired
  CartService cartService;

  @CrossOrigin
  @GetMapping("carts")
  public List<Cart> getAllCarts() {
    return cartService.getAllCarts();
  }

  @CrossOrigin
  @GetMapping("carts/{idCart}")
  public Cart getCartById(@PathVariable Long idCart) {
    return cartService.getCartById(idCart);
  }

  @CrossOrigin
  @PostMapping("carts")
  public Cart addCart(@RequestBody Cart cart) {
    return cartService.addCart(cart);
  }

  @CrossOrigin
  @PutMapping("carts")
  public Cart updateCart(@RequestBody Cart cart) {
    return cartService.addCart(cart);
  }

}
