package com.api.api_e_commerce_project_gradute.popup_ads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopupAdsRepository extends JpaRepository<PopupAds,Long> {

  @Query(value = "SELECT * FROM popup_ads ORDER BY time_created DESC LIMIT ?1 , ?2",nativeQuery = true)
  List<PopupAds> getPopupAdsLimit(int offset,int limit);

  @Query(value = "SELECT * FROM popup_ads WHERE is_show = 0 ORDER BY time_created DESC LIMIT 0 , 1 ",nativeQuery = true)
  PopupAds getPopupAdsNew();
}
