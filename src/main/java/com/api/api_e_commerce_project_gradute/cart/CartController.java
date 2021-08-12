package com.api.api_e_commerce_project_gradute.cart;

import com.api.api_e_commerce_project_gradute.DTO.cart.CartFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
  public Optional<Cart> getCartById(@PathVariable Long idCart) {
    return cartService.getCartById(idCart);
  }

  @CrossOrigin
  @GetMapping("getAllCartByIdUser/{idUser}")
  public List<CartFull> getAllCartByIdUser(@PathVariable String idUser) {
    return cartService.getAllCartByIdUser(idUser);
  }

  @CrossOrigin
  @PostMapping("carts")
  public List<CartFull> addCart(@RequestBody Cart cart) {
    return cartService.addCart(cart);
  }

  @CrossOrigin
  @GetMapping("checkCart/{idUser}/{idProduct}")
  public Cart checkCart(@PathVariable String idUser,@PathVariable String idProduct) {
    return cartService.checkCart(idUser, idProduct);
  }

  @CrossOrigin
  @PutMapping("updateCart")
  public List<CartFull> updateCart(@RequestParam int amount,@RequestParam Long idCart,@RequestParam String idUser) {
    return cartService.updateCart(amount,idCart,idUser);
  }

  @CrossOrigin
  @DeleteMapping("carts")
  public List<CartFull> deleteCart(@RequestParam String idUser,@RequestParam Long idCart) {
    return cartService.deleteCart(idCart, idUser);
  }

}
