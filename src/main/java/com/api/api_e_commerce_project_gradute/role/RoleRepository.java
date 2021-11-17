package com.api.api_e_commerce_project_gradute.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    @Query(value = "SELECT * FROM role WHERE id != 'CUSTOMER' AND id != 'LEADER' ",nativeQuery = true)
    List<Role> getRoleMain();

}
