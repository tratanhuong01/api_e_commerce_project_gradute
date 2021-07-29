package com.api.api_e_commerce_project_gradute.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @CrossOrigin
  @GetMapping("users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @CrossOrigin
  @GetMapping("users/{idUser}")
  public Optional<User> getUserById(@PathVariable String idUser) {
    return userService.getUserById(idUser);
  }

  @CrossOrigin
  @PostMapping("users")
  public User addUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @CrossOrigin
  @PutMapping("users")
  public User updateUser(@RequestBody User user) {
    return userService.addUser(user);
  }

}
