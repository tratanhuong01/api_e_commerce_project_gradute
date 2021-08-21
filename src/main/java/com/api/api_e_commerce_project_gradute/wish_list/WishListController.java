package com.api.api_e_commerce_project_gradute.wish_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishListController {

  @Autowired
  WishListService wishListService;

  @CrossOrigin
  @GetMapping("wistLists/{id}")
  public List<WishList> getWishListByIdUser(@PathVariable String id) {
    return wishListService.getWistListByIdUser(id);
  }

  @CrossOrigin
  @PostMapping("wistLists")
  public WishList addWishList(@RequestBody WishList wishList) {
    return wishListService.addWishList(wishList);
  }

  @CrossOrigin
  @PutMapping("wistLists")
  public WishList updateWishList(@RequestBody WishList wishList) {
    return wishListService.addWishList(wishList);
  }

}
