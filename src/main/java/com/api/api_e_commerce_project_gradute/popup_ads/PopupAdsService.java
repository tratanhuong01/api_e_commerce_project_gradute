package com.api.api_e_commerce_project_gradute.popup_ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service

public class PopupAdsService {

  @Autowired
  PopupAdsRepository popupAdsRepository;

  public List<PopupAds> getPopupAdsAll() {
    return popupAdsRepository.findAll();
  }

  public List<PopupAds> getPopupAdsLimit(int offset, int limit) {
    return popupAdsRepository.getPopupAdsLimit(offset, limit);
  }

  public PopupAds addPopupAds(PopupAds popupAds) {
    popupAds.setTimeCreated(new Timestamp(new Date().getTime()));
    return popupAdsRepository.save(popupAds);
  }

  public PopupAds updatePopupAds(PopupAds popupAds) {
    return popupAdsRepository.save(popupAds);
  }

  public void deletePopupAds(PopupAds popupAds) {
    popupAdsRepository.delete(popupAds);
  }

}
