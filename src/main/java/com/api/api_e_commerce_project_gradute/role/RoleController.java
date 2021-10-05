package com.api.api_e_commerce_project_gradute.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class RoleController {

  @Autowired
  RoleService roleService;

  @GetMapping("rolesAll")
  public List<Role> getAllRole() {
    return roleService.getAllRole();
  }

  @PostMapping("roles")
  public Role addRole(@RequestBody Role role) {
    return roleService.addRole(role);
  }

  @PutMapping("roles")
  public Role updateRole(@RequestBody Role role) {
    return roleService.updateRole(role);
  }

  @DeleteMapping("roles")
  public void deleteRole(@RequestBody Role role) {
    roleService.deleteRole(role);
  }

}
