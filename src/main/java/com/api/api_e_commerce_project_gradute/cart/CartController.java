package com.api.api_e_commerce_project_gradute.cart;

import com.api.api_e_commerce_project_gradute.DTO.cart.CartFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class CartController {

  @Autowired
  CartService cartService;

  @GetMapping("carts")
  public List<Cart> getAllCarts() {
    return cartService.getAllCarts();
  }

  @GetMapping("carts/{id}")
  public Optional<Cart> getCartById(@PathVariable Long id) {
    return cartService.getCartById(id);
  }

  @GetMapping("carts/{id}/user")
  public List<CartFull> getAllCartByIdUser(@PathVariable String id) {
    return cartService.getAllCartByIdUser(id);
  }

  @PostMapping("carts")
  public List<CartFull> addCart(@RequestBody Cart cart) {
    return cartService.addCart(cart);
  }

  @GetMapping("check-cart/{idUser}/{idProduct}")
  public Cart checkCart(@PathVariable String idUser,@PathVariable String idProduct) {
    return cartService.checkCart(idUser, idProduct);
  }

  @PutMapping("update-cart")
  public List<CartFull> updateCart(@RequestParam int amount,@RequestParam Long idCart,@RequestParam String idUser) {
    return cartService.updateCart(amount,idCart,idUser);
  }

  @DeleteMapping("carts")
  public List<CartFull> deleteCart(@RequestParam String idUser,@RequestParam Long idCart) {
    return cartService.deleteCart(idCart, idUser);
  }

}
