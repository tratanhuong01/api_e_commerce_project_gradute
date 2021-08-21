package com.api.api_e_commerce_project_gradute.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoryService {

  @Autowired
  MemoryRepository memoryRepository;

  public List<Memory> getAllMemories() {
    return memoryRepository.findAll();
  }

  public Optional<Memory> getMemoryById(String idMemory) {
    return memoryRepository.findById(idMemory);
  }

  public Memory addMemory(Memory memory) {
    return memoryRepository.save(memory);
  }

}