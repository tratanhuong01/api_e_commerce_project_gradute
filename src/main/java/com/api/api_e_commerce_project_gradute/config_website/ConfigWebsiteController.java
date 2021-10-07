package com.api.api_e_commerce_project_gradute.config_website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class ConfigWebsiteController {

  @Autowired
  ConfigWebsiteService configWebsiteService;

  @GetMapping("configWebsitesAll")
  public List<ConfigWebsite> getConfigWebsiteAll() {
    return configWebsiteService.getConfigWebsiteAll();
  }

  @GetMapping("configWebsites")
  public List<ConfigWebsite> getConfigWebsiteAllLimit() {
    return configWebsiteService.getConfigWebsiteLimit(0,10);
  }

  @GetMapping("configWebsites/{offset}/{limit}")
  public List<ConfigWebsite> getConfigWebsiteLimit(@PathVariable int offset, @PathVariable int limit) {
    return configWebsiteService.getConfigWebsiteLimit(offset, limit);
  }

  @PostMapping("configWebsites")
  public ConfigWebsite addConfigWebsite(@RequestBody ConfigWebsite configWebsite) {
    return configWebsiteService.addConfigWebsite(configWebsite);
  }

  @PutMapping("configWebsites")
  public ConfigWebsite updateConfigWebsite(@RequestBody ConfigWebsite configWebsite) {
    return configWebsiteService.updateConfigWebsite(configWebsite);
  }

  @DeleteMapping("configWebsites")
  public void deleteConfigWebsite(@RequestBody ConfigWebsite configWebsite) {
    configWebsiteService.deleteConfigWebsite(configWebsite);
  }

  @GetMapping("configWebsites/type/{type}")
  public ConfigWebsite getConfigWebsiteByType(@PathVariable int type) {
    return configWebsiteService.getConfigWebsiteByType(type);
  }

}
