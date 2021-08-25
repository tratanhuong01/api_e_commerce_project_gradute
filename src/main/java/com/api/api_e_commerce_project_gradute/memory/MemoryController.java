package com.api.api_e_commerce_project_gradute.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemoryController {

  @Autowired
  MemoryService memoryService;

  @CrossOrigin
  @GetMapping("memories")
  public List<Memory> getAllMemories() {
    return memoryService.getMemoriesLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("memories/{offset}/{limit}")
  public List<Memory> getMemoriesLimit(@PathVariable  int offset,@PathVariable int limit) {
    return memoryService.getMemoriesLimit(offset, limit);
  }

  @CrossOrigin
  @GetMapping("memories/{idMemory}")
  public Optional<Memory> getMemoryById(@PathVariable String idMemory) {
    return memoryService.getMemoryById(idMemory);
  }

  @CrossOrigin
  @PostMapping("memories")
  public Memory addMemory(@RequestBody Memory memory) {
    return memoryService.addMemory(memory);
  }

  @CrossOrigin
  @PutMapping("memories")
  public Memory updateMemory(@RequestBody Memory memory) {
    return memoryService.addMemory(memory);
  }

}
