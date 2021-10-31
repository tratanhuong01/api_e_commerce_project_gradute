package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.DTO.AccountLogin;
import com.api.api_e_commerce_project_gradute.DTO.DataSendMail;
import com.api.api_e_commerce_project_gradute.DTO.UpdateStatus;
import com.api.api_e_commerce_project_gradute.DTO.UserDetail;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.user.UserCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.user.UserFull;
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

  @GetMapping("userFilters")
  public List<UserFull> getAllUsersLimit(String userType, String sex, Integer verifyPhone, Integer ageFrom,
                                    Integer ageTo, Integer status, Integer verifyEmail,String ageSorter,
                                    String timeRegisterSorter,String keyword,Integer offset, Integer limit,
                                    Integer isRegister) {
    UserCriteria userCriteria = UserCriteria.builder().
        userType(userType).
        sex(sex).
        verifyPhone(verifyPhone).
        verifyEmail(verifyEmail).
        ageFrom(ageFrom == null ? null : ageFrom * 365).
        ageTo(ageTo == null ? null : ageTo * 365).
        status(status).
        ageSorter(ageSorter).
        timeRegisterSorter(timeRegisterSorter).
        keyword(keyword).
        isRegister(isRegister).
        offset(offset).
        limit(limit).
        build();
    return userService.filterUserLimit(userCriteria);
  }

  @GetMapping("userFiltersAll")
  public Integer getAllUsersAll(String userType, String sex, Integer verifyPhone, Integer ageFrom,
                                    Integer ageTo, Integer status, Integer verifyEmail,String ageSorter,
                                    String timeRegisterSorter,String keyword,Integer isRegister) {
    UserCriteria userCriteria = UserCriteria.builder().
        userType(userType).
        sex(sex).
        verifyPhone(verifyPhone).
        verifyEmail(verifyEmail).
        ageFrom(ageFrom == null ? null : ageFrom * 365).
        ageTo(ageTo == null ? null : ageTo * 365).
        status(status).
        ageSorter(ageSorter).
        timeRegisterSorter(timeRegisterSorter).
        keyword(keyword).
        isRegister(isRegister).
        build();
    return userService.filterUserAll(userCriteria);
  }

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
  public User getUserById(@PathVariable String idUser) {
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

  @PostMapping("checkLoginJWT")
  public UserDetail checkLoginJWT(@RequestBody AccountLogin accountLogin) {
    return userService.checkLoginJWT(accountLogin);
  }

  @PostMapping("verifyAccountJWT")
  public UserDetail verifyAccountJWT(@RequestBody AccountLogin accountLogin) {
    return userService.verifyAccountJWT(accountLogin);
  }

  @PostMapping("adminCheckLoginJWT")
  public UserDetail adminCheckLoginJWT(@RequestBody AccountLogin accountLogin) {
    return userService.adminCheckLoginJWT(accountLogin);
  }

  @PostMapping("getUserFromJWT")
  public UserDetail getUserFromJWT(@RequestBody String token) {
    return userService.getUserFromJWT(token);
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
  public List<User> getUserByTypeLimit(@RequestParam(required = false) String idRole , @RequestParam(required = false) int offset,
                                       @RequestParam(required = false) int limit) {
    return userService.getUserByTypeLimit(idRole, offset, limit);
  }

  @PutMapping("users/update/status/")
  public int updateStatusUser(@RequestBody UpdateStatus updateStatus) {
    return userService.updateStatusUser(updateStatus.getValue(),updateStatus.getId());
  }

  @PostMapping("getUserByIdRole")
  public List<User> getUserByIdRole(@RequestParam String role)  {
    return userService.getUserByIdRole(role);
  }

  @DeleteMapping("users")
  public void deleteUser(@RequestBody User user) {
    userService.deleteUser(user);
  }

  @PostMapping("checkEmailHave")
  public UserDetail checkEmailHave(@RequestBody String email) {
    return userService.checkEmailHave(email);
  }

  @PostMapping("checkPassword/")
  public User checkPassword(@RequestParam String idUser,@RequestBody String password) {
    return userService.checkPassword(password,idUser);
  }

  @PutMapping("updatePhone/")
  public int updatePhone(@RequestParam String idUser,@RequestBody String phone) {
    return userService.updatePhone(idUser, phone);
  }

  @PutMapping("updateEmail/")
  public int updateEmail(@RequestParam String idUser,@RequestBody String email) {
    return userService.updateEmail(idUser, email);
  }

  @PostMapping("searchUserByEmailOrPhone")
  public User searchUserByEmailOrPhone(@RequestBody String emailOrPhone) {
    return userService.searchUserByEmailOrPhone(emailOrPhone);
  }

}
