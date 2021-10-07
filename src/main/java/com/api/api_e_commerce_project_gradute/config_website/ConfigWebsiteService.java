package com.api.api_e_commerce_project_gradute.config_website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service

public class ConfigWebsiteService {

  @Autowired
  ConfigWebsiteRepository configWebsiteRepository;

  public List<ConfigWebsite> getConfigWebsiteAll() {
    return configWebsiteRepository.findAll();
  }

  public List<ConfigWebsite> getConfigWebsiteLimit(int offset,int limit) {
    return configWebsiteRepository.getConfigWebsiteLimit(offset,limit);
  }

  public ConfigWebsite addConfigWebsite(ConfigWebsite configWebsite) {
    configWebsite.setTimeCreated(new Timestamp(new Date().getTime()));
    return configWebsiteRepository.save(configWebsite);
  }

  public ConfigWebsite updateConfigWebsite(ConfigWebsite configWebsite) {
    return configWebsiteRepository.save(configWebsite);
  }

  public void deleteConfigWebsite(ConfigWebsite configWebsite) {
    configWebsiteRepository.delete(configWebsite);
  }

  public ConfigWebsite getConfigWebsiteByType(int type) {
    return configWebsiteRepository.getConfigWebsiteByType(type);
  }

}
