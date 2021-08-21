package com.api.api_e_commerce_project_gradute.wish_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class WishListService {

  @Autowired
  WishListRepository wishListRepository;

  public List<WishList> getWistListByIdUser(String idUser) {
    return wishListRepository.getWishListByIdUser(idUser);
  }

  public WishList addWishList(WishList wishList) {
    return wishListRepository.save(wishList);
  }

}
