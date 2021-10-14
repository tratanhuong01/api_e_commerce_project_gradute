package com.api.api_e_commerce_project_gradute.password_reset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PasswordResetService {

  @Autowired
  PasswordResetRepository passwordResetRepository;

  public PasswordReset addPasswordReset(PasswordReset passwordReset) {
    passwordReset.setTimeCreated(new Timestamp(new Date().getTime()));
    return passwordResetRepository.save(passwordReset);
  }

  public PasswordReset updatePasswordReset(PasswordReset passwordReset) {
    return passwordResetRepository.save(passwordReset);
  }

  public void deletePasswordReset(PasswordReset passwordReset) {
    passwordResetRepository.delete(passwordReset);
  }

  public List<PasswordReset> getListPasswordReset(String idUser) {
    return passwordResetRepository.getListPasswordReset(idUser);
  }

}
