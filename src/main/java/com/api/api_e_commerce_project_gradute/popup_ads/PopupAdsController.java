package com.api.api_e_commerce_project_gradute.popup_ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class PopupAdsController {

  @Autowired
  PopupAdsService popupAdsService;

  @GetMapping("popupAdsAll")
  public List<PopupAds> getPopupAdsAll() {
    return popupAdsService.getPopupAdsAll();
  }

  @GetMapping("popupAds")
  public List<PopupAds> getPopupAdsAllLimit() {
    return popupAdsService.getPopupAdsLimit(0,10);
  }

  @GetMapping("popupAds/{offset}/{limit}")
  public List<PopupAds> getPopupAdsLimit(@PathVariable int offset,@PathVariable int limit) {
    return popupAdsService.getPopupAdsLimit(offset, limit);
  }

  @PostMapping("popupAds")
  public PopupAds addPopupAds(@RequestBody PopupAds popupAds) {
    return popupAdsService.addPopupAds(popupAds);
  }

  @PutMapping("popupAds")
  public PopupAds updatePopupAds(@RequestBody PopupAds popupAds) {
    return popupAdsService.updatePopupAds(popupAds);
  }

  @DeleteMapping("popupAds")
  public void deletePopupAds(@RequestBody PopupAds popupAds) {
    popupAdsService.deletePopupAds(popupAds);
  }



}
