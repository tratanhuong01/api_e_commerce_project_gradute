package com.api.api_e_commerce_project_gradute.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

  @Autowired
  BankRepository bankRepository;

  public List<Bank> getAllBank() {
    return bankRepository.findAll();
  }

  public Optional<Bank> getBankById(Long id) {
    return bankRepository.findById(id);
  }

  public List<Bank> getBankByIdUser(String id) {
    return bankRepository.getBankByIdUser(id);
  }

  public List<Bank> addBank(Bank bank) {
    bankRepository.save(bank);
    return bankRepository.findAll();
  }

}
