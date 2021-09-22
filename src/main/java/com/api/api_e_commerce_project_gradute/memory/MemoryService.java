package com.api.api_e_commerce_project_gradute.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
    memory.setTimeCreated(new Timestamp(new Date().getTime()));
    return memoryRepository.save(memory);
  }

  public Memory updateMemory(Memory memory) {
    return memoryRepository.save(memory);
  }

  public List<Memory> getMemoriesLimit(int offset,int limit) {
    return memoryRepository.getMemoriesLimit(offset, limit);
  }

  public List<Memory> searchMemoryAll(String keyword) {
    return memoryRepository.searchMemoryAll(keyword);
  }

  public List<Memory> searchMemoryLimit(String keyword, int offset, int limit) {
    return memoryRepository.searchMemoryLimit(keyword,offset,limit);
  }

  public void deleteMemory(Memory memory) {
    memoryRepository.delete(memory);
  }

}
