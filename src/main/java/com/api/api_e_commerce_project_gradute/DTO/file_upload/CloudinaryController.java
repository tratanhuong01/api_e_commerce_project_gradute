package com.api.api_e_commerce_project_gradute.DTO.file_upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class CloudinaryController {

  @Autowired
  CloudinaryService cloudinaryService;

  @CrossOrigin
  @PostMapping("updateImageSingle")
  public ResponseEntity<Map> updateImageSingle(@RequestParam(required = false) String id,
                                               @RequestParam(required = false,value = "multipartFile") MultipartFile multipartFile,
                                               @RequestParam(required = false) String publicId) throws IOException {
    ImageSingle imageSingle = new ImageSingle();
    imageSingle.setMultipartFile(multipartFile);
    imageSingle.setId(id);
    imageSingle.setPublicId(publicId);
    Map result = cloudinaryService.uploadSingle(imageSingle);
    return new ResponseEntity(result, HttpStatus.OK);
  }

  }
