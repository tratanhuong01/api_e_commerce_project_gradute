package com.api.api_e_commerce_project_gradute.wish_list;

import com.api.api_e_commerce_project_gradute.DTO.cart.CartFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishListController {

  @Autowired
  WishListService wishListService;

  @CrossOrigin
  @GetMapping("wishLists/{id}")
  public List<WishList> getWishListByIdUser(@PathVariable String id) {
    return wishListService.getWistListByIdUser(id);
  }

  @CrossOrigin
  @GetMapping("getAllWishListByIdUser/{id}")
  public List<CartFull> getAllWishListByIdUser(@PathVariable String id) {
    return wishListService.getAllWishListByIdUser(id);
  }

  @CrossOrigin
  @GetMapping("checkWishList/{idUser}/{idProduct}")
  public WishList getAllWishListByIdUser(@PathVariable String idUser,@PathVariable String idProduct) {
    return wishListService.checkWishList(idUser, idProduct);
  }

  @CrossOrigin
  @PostMapping("wishLists")
  public List<CartFull> addWishList(@RequestBody WishList wishList) {
    return wishListService.addWishList(wishList);
  }

  @CrossOrigin
  @DeleteMapping("wishLists/{idUser}/{idWishList}")
  public List<CartFull> updateWishList(@PathVariable String idUser,@PathVariable Long idWishList) {
    return wishListService.deleteWishList(idWishList,idUser);
  }

}
