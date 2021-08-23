package com.api.api_e_commerce_project_gradute.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankController {

  @Autowired
  BankService bankService;

  @CrossOrigin
  @GetMapping("banks")
  public List<Bank> getAllBank() {
    return bankService.getAllBank();
  }

  @CrossOrigin
  @GetMapping("banks/{id}")
  public List<Bank> getBankByIdUser(@PathVariable String id) {
    return bankService.getBankByIdUser(id);
  }

  @CrossOrigin
  @PostMapping("banks")
  public List<Bank> addBank(@RequestBody Bank bank) {
    return bankService.addBank(bank);
  }

  @CrossOrigin
  @PutMapping("banks")
  public List<Bank> updateBank(@RequestBody Bank bank) {
    return bankService.addBank(bank);
  }


}
