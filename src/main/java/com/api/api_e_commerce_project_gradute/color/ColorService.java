package com.api.api_e_commerce_project_gradute.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
    color.setTimeCreated(new Timestamp(new Date().getTime()));
    return colorRepository.save(color);
  }

  public Color updateColor(Color color) {
    return colorRepository.save(color);
  }

  public List<Color> searchColorAll(String keyword) {
    return colorRepository.searchColorAll(keyword);
  }

  public List<Color> searchColorLimit(String keyword, int offset, int limit) {
    return colorRepository.searchColorLimit(keyword,offset,limit);
  }

  public void deleteColor(Color color) {
    colorRepository.delete(color);
  }

  public List<Color> getListColorByLineProduct(String idLineProduct) {
    return colorRepository.getListColorByLineProduct(idLineProduct);
  }

}
