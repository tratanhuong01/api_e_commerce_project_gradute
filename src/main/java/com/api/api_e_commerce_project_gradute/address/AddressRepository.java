package com.api.api_e_commerce_project_gradute.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

  @Query(value = "SELECT * FROM address WHERE id_user = ?1 ",nativeQuery = true)
  List<Address> getAddressByIdUser(String id);

}
