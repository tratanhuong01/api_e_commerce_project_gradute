package com.api.api_e_commerce_project_gradute.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

  @Autowired
  ColorRepository colorRepository;

  public List<Color> getAllColors() {
    return colorRepository.findAll();
  }

  public Color getColorById(String idColor) {
    return colorRepository.getById(idColor);
  }

  public Color addColor(Color color) {
    return colorRepository.save(color);
  }

}
