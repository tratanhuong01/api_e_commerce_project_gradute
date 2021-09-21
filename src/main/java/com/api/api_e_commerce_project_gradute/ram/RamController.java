package com.api.api_e_commerce_project_gradute.ram;

import com.api.api_e_commerce_project_gradute.memory.Memory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class RamController {

  @Autowired
  RamService ramService;

  // admin

  @GetMapping("ramsAll/search/")
  public List<Ram> searchRamAll(@RequestParam(required = false) String keyword) {
    return ramService.searchRamAll(keyword);
  }

  @GetMapping("rams/search/")
  public List<Ram> searchRamLimit(@RequestParam(required = false) String keyword, @RequestParam(required = false) int offset,
                                  @RequestParam(required = false) int limit) {
    return ramService.searchRamLimit(keyword,offset,limit);
  }

  @DeleteMapping("rams")
  public void deleteRam(@RequestBody Ram ram) {
    ramService.deleteRam(ram);
  }

  // user

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