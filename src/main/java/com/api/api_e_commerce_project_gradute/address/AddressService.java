package com.api.api_e_commerce_project_gradute.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

  @Autowired
  AddressRepository addressRepository;

  public List<Address> getAllAddress() {
    return addressRepository.findAll();
  }

  public Optional<Address> getAddressById(Long id) {
    return addressRepository.findById(id);
  }

  public List<Address> addAddress(Address address) {
     addressRepository.save(address);
     return addressRepository.findAll();
  }

  public List<Address> getAddressByIdUser(String id) {
    return addressRepository.getAddressByIdUser(id);
  }

  public List<Address> deleteAddress(Long id) {
    addressRepository.deleteById(id);
    return addressRepository.findAll();
  }

}
