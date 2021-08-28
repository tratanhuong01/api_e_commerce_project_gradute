package com.api.api_e_commerce_project_gradute.ram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RamController {

  @Autowired
  RamService ramService;

  @CrossOrigin
  @GetMapping("ramsAll")
  public List<Ram> getAllRams() {
    return ramService.getAllRams();
  }

  @CrossOrigin
  @GetMapping("rams/{idRam}")
  public Optional<Ram> getRamById(@PathVariable String idRam) {
    return ramService.getRamById(idRam);
  }

  @CrossOrigin
  @PostMapping("rams")
  public Ram addSize(@RequestBody Ram ram) {
    return ramService.addRam(ram);
  }

  @CrossOrigin
  @PutMapping("rams")
  public Ram updateRam(@RequestBody Ram ram) {
    return ramService.addRam(ram);
  }

}