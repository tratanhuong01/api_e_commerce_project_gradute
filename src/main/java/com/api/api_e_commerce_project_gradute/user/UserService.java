package com.api.api_e_commerce_project_gradute.user;

import com.api.api_e_commerce_project_gradute.DTO.AccountLogin;
import com.api.api_e_commerce_project_gradute.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(String idUser) {
    return userRepository.findById(idUser);
  }

  public User addUser(User user) {
    User userBestNew = userRepository.getIdBestNew();
    int id = Config.ID_USER_DEFAULT;
    if (userBestNew == null) {
    }
    else {
      id = Integer.parseInt(userBestNew.getId());
      id++;
    }
    user.setId(String.valueOf(id));
    user.setTimeCreated((new Timestamp(new Date().getTime())));
    return userRepository.save(user);
  }

  public List<User> getUserByEmail(String email) {
    return userRepository.getUserByEmail(email);
  }

  public List<User> getUserByPhone(String phone) {
    return userRepository.getUserByPhone(phone);
  }

  public User checkLogin(AccountLogin accountLogin) {
    return checkLogin(accountLogin);
  }

  public String updateCodeEmail(String codeEmail,String idUser) {
    return userRepository.updateCodeEmail(codeEmail,idUser);
  }

}
