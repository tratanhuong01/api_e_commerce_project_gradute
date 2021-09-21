package com.api.api_e_commerce_project_gradute.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class MemoryController {

  @Autowired
  MemoryService memoryService;

  // admin

  @GetMapping("memoriesAll/search/")
  public List<Memory> searchMemoryAll(String keyword) {
    return memoryService.searchMemoryAll(keyword);
  }

  @GetMapping("memories/search/")
  public List<Memory> searchMemoryLimit(String keyword, int offset, int limit) {
    return memoryService.searchMemoryLimit(keyword,offset,limit);
  }

  @DeleteMapping("memories")
  public void deleteMemory(Memory memory) {
    memoryService.deleteBrand(memory);
  }

  // user

  @GetMapping("memoriesAll")
  public List<Memory> getAllMemories() {
    return memoryService.getAllMemories();
  }

  @GetMapping("memories")
  public List<Memory> getAll() {
    return memoryService.getMemoriesLimit(0,10);
  }

  @GetMapping("memories/{offset}/{limit}")
  public List<Memory> getMemoriesLimit(@PathVariable  int offset,@PathVariable int limit) {
    return memoryService.getMemoriesLimit(offset, limit);
  }

  @GetMapping("memories/{idMemory}")
  public Optional<Memory> getMemoryById(@PathVariable String idMemory) {
    return memoryService.getMemoryById(idMemory);
  }

  @PostMapping("memories")
  public Memory addMemory(@RequestBody Memory memory) {
    return memoryService.addMemory(memory);
  }

  @PutMapping("memories")
  public Memory updateMemory(@RequestBody Memory memory) {
    return memoryService.addMemory(memory);
  }

}
