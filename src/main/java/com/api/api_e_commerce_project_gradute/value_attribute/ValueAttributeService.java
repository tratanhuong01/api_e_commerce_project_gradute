package com.api.api_e_commerce_project_gradute.value_attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueAttributeService {

  @Autowired
  ValueAttributeRepository valueAttributeRepository;

  public List<ValueAttribute> getAllValueAttribute() {
    return valueAttributeRepository.findAll();
  }

  public List<ValueAttribute> getAllValueAtributeLimit(int offset,int limit) {
    return valueAttributeRepository.getAllValueAttributeLimit(offset, limit);
  }

  public List<ValueAttribute> addValueAttribute(ValueAttribute valueAttribute) {
    valueAttributeRepository.save(valueAttribute);
    return valueAttributeRepository.findAll();
  }

}
