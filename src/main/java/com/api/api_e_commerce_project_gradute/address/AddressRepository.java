package com.api.api_e_commerce_project_gradute.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

  @Query(value = "SELECT * FROM address WHERE id_user = ?1 ",nativeQuery = true)
  List<Address> getAddressByIdUser(String id);

  @Modifying
  @Transactional
  @Query(value = "UPDATE address SET is_default = 1 WHERE id_user = ?1 AND id = ?2 ",nativeQuery = true)
  int setDefaultAddress(String idUser,Long idAddress);

  @Modifying
  @Transactional
  @Query(value = "UPDATE address SET is_default = 0 WHERE id_user = ?1",nativeQuery = true)
  int setDefaultAddressMain(String idUser);
}
