package com.api.api_e_commerce_project_gradute.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return userRepository.save(user);
  }

}
