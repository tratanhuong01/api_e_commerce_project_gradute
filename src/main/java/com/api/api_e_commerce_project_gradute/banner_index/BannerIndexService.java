package com.api.api_e_commerce_project_gradute.banner_index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service

public class BannerIndexService {

  @Autowired
  BannerIndexRepository bannerIndexRepository;

  public List<BannerIndex> getBannerIndexAll() {
    return bannerIndexRepository.findAll();
  }

  public List<BannerIndex> getBannerIndexLimit(int offset,int limit) {
    return bannerIndexRepository.getBannerIndexLimit(offset,limit);
  }

  public BannerIndex addBannerIndex(BannerIndex bannerIndex) {
    bannerIndex.setTimeCreated((new Timestamp(new Date().getTime())));
    return bannerIndexRepository.save(bannerIndex);
  }

  public BannerIndex updateBannerIndex(BannerIndex bannerIndex) {
    return bannerIndexRepository.save(bannerIndex);
  }

  public void deleteBannerIndex(BannerIndex bannerIndex) {
    bannerIndexRepository.delete(bannerIndex);
  }

  public BannerIndex getBannerIndexShow() {
    return bannerIndexRepository.getBannerIndexShow();
  }

}
