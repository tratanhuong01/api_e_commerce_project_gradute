package com.api.api_e_commerce_project_gradute.ram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class RamController {

  @Autowired
  RamService ramService;

  @GetMapping("ramsAll")
  public List<Ram> getAllRams() {
    return ramService.getAllRams();
  }

  @GetMapping("rams/{idRam}")
  public Optional<Ram> getRamById(@PathVariable String idRam) {
    return ramService.getRamById(idRam);
  }

  @PostMapping("rams")
  public Ram addSize(@RequestBody Ram ram) {
    return ramService.addRam(ram);
  }

  @PutMapping("rams")
  public Ram updateRam(@RequestBody Ram ram) {
    return ramService.addRam(ram);
  }

}