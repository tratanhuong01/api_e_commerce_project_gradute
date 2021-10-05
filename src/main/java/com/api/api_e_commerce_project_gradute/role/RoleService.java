package com.api.api_e_commerce_project_gradute.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

  @Autowired
  RoleRepository roleRepository;

  public List<Role> getAllRole() {
    return roleRepository.findAll();
  }

  public Role addRole(Role role) {
    return roleRepository.save(role);
  }

  public Role updateRole(Role role) {
    return roleRepository.save(role);
  }

  public void deleteRole(Role role) {
    roleRepository.delete(role);
  }

}
