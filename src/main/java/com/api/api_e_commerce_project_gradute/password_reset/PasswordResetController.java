package com.api.api_e_commerce_project_gradute.password_reset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class PasswordResetController {

  @Autowired
  PasswordResetService passwordResetService;

  @PostMapping("passwordResets")
  public PasswordReset addPasswordReset(@RequestBody PasswordReset passwordReset) {
    return passwordResetService.addPasswordReset(passwordReset);
  }

  @PutMapping("passwordResets")
  public PasswordReset updatePasswordReset(@RequestBody PasswordReset passwordReset) {
    return passwordResetService.updatePasswordReset(passwordReset);
  }

  @DeleteMapping("passwordResets")
  public void deletePasswordReset(@RequestBody PasswordReset passwordReset) {
    passwordResetService.deletePasswordReset(passwordReset);
  }

  @PostMapping("getListPasswordReset")
  public List<PasswordReset> getListPasswordReset(@RequestBody String idUser) {
    return passwordResetService.getListPasswordReset(idUser);
  }

}
