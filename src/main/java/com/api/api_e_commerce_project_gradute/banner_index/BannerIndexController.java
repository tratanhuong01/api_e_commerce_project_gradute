package com.api.api_e_commerce_project_gradute.banner_index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class BannerIndexController {

  @Autowired
  BannerIndexService bannerIndexService;

  @GetMapping("bannerIndexesAll")
  public List<BannerIndex> getAllBannerIndexAll() {
    return bannerIndexService.getBannerIndexAll();
  }

  @GetMapping("bannerIndexes")
  public List<BannerIndex> getAllBannerIndexALLimit() {
    return bannerIndexService.getBannerIndexLimit(0,10);
  }

  @GetMapping("bannerIndexes/{offset}/{limit}")
  public List<BannerIndex> getAllBannerIndexLimit(@PathVariable int offset,@PathVariable int limit) {
    return bannerIndexService.getBannerIndexLimit(offset, limit);
  }

  @PostMapping("bannerIndexes")
  public BannerIndex addBannerIndex(@RequestBody BannerIndex bannerIndex) {
    return bannerIndexService.addBannerIndex(bannerIndex);
  }

  @PutMapping("bannerIndexes")
  public BannerIndex updateBannerIndex(@RequestBody BannerIndex bannerIndex) {
    return bannerIndexService.updateBannerIndex(bannerIndex);
  }

  @DeleteMapping("bannerIndexes")
  public void deleteBannerIndex(@RequestBody BannerIndex bannerIndex) {
    bannerIndexService.deleteBannerIndex(bannerIndex);
  }

  @GetMapping("getBannerIndexShow")
  public BannerIndex getBannerIndexShow() {
    return bannerIndexService.getBannerIndexShow();
  }

}
