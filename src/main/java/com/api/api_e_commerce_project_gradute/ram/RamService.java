package com.api.api_e_commerce_project_gradute.ram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return ramRepository.save(ram);
  }

}