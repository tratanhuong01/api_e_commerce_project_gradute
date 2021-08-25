package com.api.api_e_commerce_project_gradute.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

  @Autowired
  ColorRepository colorRepository;

  public List<Color> getAllColors() {
    return colorRepository.findAll();
  }

  public List<Color> getColorsLimit(int offset,int limit) {
    return colorRepository.getColorsLimit(offset, limit);
  }

  public Optional<Color> getColorById(String idColor) {
    return colorRepository.findById(idColor);
  }

  public Color addColor(Color color) {
    return colorRepository.save(color);
  }



}
