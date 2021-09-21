package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.DTO.AccountLogin;
import com.api.api_e_commerce_project_gradute.DTO.DataSendMail;
import com.api.api_e_commerce_project_gradute.config.Config;
import com.api.api_e_commerce_project_gradute.mail.MailService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  MailService mailService;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(String idUser) {
    return userRepository.findById(idUser);
  }

  public User addUser(User user) {
    if (user.getId() != null) {
    }
    else {
      User userBestNew = userRepository.getIdBestNew();
      int id = Config.ID_USER_DEFAULT;
      if (userBestNew == null) {
      }
      else {
        id = Integer.parseInt(userBestNew.getId());
        id++;
      }
      user.setId(String.valueOf(id));
      user.setPassword(DigestUtils.md5Hex(user.getPassword()).toUpperCase());
      user.setTimeCreated((new Timestamp(new Date().getTime())));
    }
    return userRepository.save(user);
  }

  public List<User> getUserByEmail(String email) {
    return userRepository.getUserByEmail(email);
  }

  public List<User> getUserByPhone(String phone) {
    return userRepository.getUserByPhone(phone);
  }

  public User checkLogin(AccountLogin accountLogin) {
    return userRepository.checkLogin(accountLogin.getEmailOrPhone(),
        DigestUtils.md5Hex(accountLogin.getPassword()).toUpperCase());
  }

  public String checkPasswordUser(String idUser,String password) {
    return userRepository.checkPasswordUser(idUser,DigestUtils.md5Hex(password).toUpperCase());
  }

  public String updateCodeEmail(User user) {
    DataSendMail dataSendMail = new DataSendMail();
    Random rnd = new Random();
    int number = rnd.nextInt(9999999);
    dataSendMail.setEmail(user.getEmail());
    dataSendMail.setBody("Your code is " + number);
    dataSendMail.setTopic("Verify Account Register In Website");
    mailService.sendMail(dataSendMail);
    userRepository.updateCodeEmail(String.valueOf(number),user.getId());
    return String.valueOf(number);
  }

  public List<User> getAllUsersLimit(int offset,int limit) {
    return userRepository.getAllUsersLimit(offset, limit);
  }

  public int updatePasswordUser(String password,String idUser) {
    return userRepository.updatePasswordUser(DigestUtils.md5Hex(password),idUser);
  }

  public User getTeleSupport() {
    List<User> userList = userRepository.getTeleSupport();
    if (userList.size() == 0)
      return null;
    else
      return userList.get(0 + (int)(Math.random() * (((userList.size() - 1) - 0) + 1)));
  }

  public List<User> getUserByTypeLimit(int type,int offset,int limit) {
    return userRepository.getUserByTypeLimit(type,offset,limit);
  }

}
