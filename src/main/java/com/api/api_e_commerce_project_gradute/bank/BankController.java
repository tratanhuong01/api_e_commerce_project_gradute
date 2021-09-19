package com.api.api_e_commerce_project_gradute.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class BankController {

  @Autowired
  BankService bankService;

  @GetMapping("banks")
  public List<Bank> getAllBank() {
    return bankService.getAllBank();
  }

  @GetMapping("banks/{id}")
  public List<Bank> getBankByIdUser(@PathVariable String id) {
    return bankService.getBankByIdUser(id);
  }

  @PostMapping("banks")
  public List<Bank> addBank(@RequestBody Bank bank) {
    return bankService.addBank(bank);
  }

  @PutMapping("banks")
  public List<Bank> updateBank(@RequestBody Bank bank) {
    return bankService.addBank(bank);
  }


}
