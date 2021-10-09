package com.api.api_e_commerce_project_gradute.DTO.file_upload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

  Cloudinary cloudinary;

  private Map<String, String> valuesMap = new HashMap<>();

  public CloudinaryService() {
//    valuesMap.put("cloud_name", "tratahuong01");
//    valuesMap.put("api_key", "766394141822312");
//    valuesMap.put("api_secret", "PNHwV43RnKYNC3MnK1ebW2dplqA");
    valuesMap.put("cloud_name", "huongdev2k1");
    valuesMap.put("api_key", "274341928974741");
    valuesMap.put("api_secret", "W9uVMJNJpKE1zJrPGr17jU2jrpg");
    cloudinary = new Cloudinary(valuesMap);
  }

  public Map uploadSingle(ImageSingle imageSingle) throws IOException {
    File file = convert(imageSingle.getMultipartFile());
    Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
        "public_id", imageSingle.getPublicId() + imageSingle.getId(),
        "overwrite", true,
        "resource_type", "image"
    ));
    file.delete();
    return result;
  }


  private File convert(MultipartFile multipartFile) throws IOException {
    File file = new File(multipartFile.getOriginalFilename());
    FileOutputStream fo = new FileOutputStream(file);
    fo.write(multipartFile.getBytes());
    fo.close();
    return file;
  }

}
