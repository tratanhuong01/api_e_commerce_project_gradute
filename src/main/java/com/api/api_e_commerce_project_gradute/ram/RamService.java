package com.api.api_e_commerce_project_gradute.ram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RamService {

  @Autowired
  RamRepository ramRepository;

  public List<Ram> getAllRams() {
    return ramRepository.findAll();
  }

  public Optional<Ram> getRamById(String idRam) {
    return ramRepository.findById(idRam);
  }

  public Ram addRam(Ram ram) {
    ram.setTimeCreated(new Timestamp(new Date().getTime()));
    return ramRepository.save(ram);
  }

  public Ram updateRam(Ram ram) {
    return ramRepository.save(ram);
  }

  public List<Ram> searchRamAll(String keyword) {
    return ramRepository.searchRamAll(keyword);
  }

  public List<Ram> searchRamLimit(String keyword, int offset, int limit) {
    return ramRepository.searchRamLimit(keyword,offset,limit);
  }

  public void deleteRam(Ram ram) {
    ramRepository.delete(ram);
  }

  public List<Ram> getRamLimit(int offset,int limit) {
    return ramRepository.getRamLimit(offset, limit);
  }

}
