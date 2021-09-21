package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.DTO.AccountLogin;
import com.api.api_e_commerce_project_gradute.DTO.DataSendMail;
import com.api.api_e_commerce_project_gradute.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  MailService mailService;

//  @GetMapping("usersAll")
//  public List<User> getAllUsers() {
//    return userService.getAllUsers();
//  }

  @GetMapping("usersAll")
  public List<User> getAllUsersLimit(@RequestParam(required = false) int type) {
    return userService.getAllUsersLimit(type,0,10);
  }

  @GetMapping("users")
  public List<User> getAllUsersLimit(@RequestParam(required = false) int offset,@RequestParam(required = false) int limit,
                                     @RequestParam(required = false) int type) {
    return userService.getAllUsersLimit(type,offset,limit);
  }

  @GetMapping("users/{idUser}")
  public Optional<User> getUserById(@PathVariable String idUser) {
    return userService.getUserById(idUser);
  }

  @PostMapping("users")
  public User addUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PutMapping("users")
  public User updateUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PostMapping("users/email")
  public List<User> getUserByEmail(@RequestParam String email) {
    return userService.getUserByEmail(email);
  }

  @PostMapping("users/phone")
  public List<User> getUserByPhone(@RequestParam String phone) {
    return userService.getUserByPhone(phone);
  }

  @PostMapping("checkLogin")
  public User checkLogin(@RequestBody AccountLogin accountLogin) {
    return userService.checkLogin(accountLogin);
  }

  @PostMapping("sendCodeEmail")
  public String sendCodeEmail(@RequestBody User user) {
    return userService.updateCodeEmail(user);
  }

  @GetMapping("users/password/")
  public String checkPasswordUser(@RequestParam(required = false) String idUser,
                                  @RequestParam(required = false) String password) {
    return userService.checkPasswordUser(idUser, password);
  }

  @GetMapping("users/password/update/")
  public int changePasswordUser(@RequestParam(required = false) String password,
                                @RequestParam(required = false) String idUser) {
    return userService.updatePasswordUser(password, idUser);
  }

  @GetMapping("getTeleSupport")
  public User getTeleSupport() {
    return userService.getTeleSupport();
  }

  @GetMapping("getUserByTypeLimit/")
  public List<User> getUserByTypeLimit(@RequestParam(required = false) int type , @RequestParam(required = false) int offset,
                                       @RequestParam(required = false) int limit) {
    return userService.getUserByTypeLimit(type, offset, limit);
  }

}
