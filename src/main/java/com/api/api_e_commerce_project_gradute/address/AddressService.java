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
    if (address.getIsDefault() == 1)
      addressRepository.setDefaultAddressMain(address.getAddressUser().getId());
     addressRepository.save(address);
     return addressRepository.getAddressByIdUser(address.getAddressUser().getId());
  }

  public List<Address> getAddressByIdUser(String id) {
    return addressRepository.getAddressByIdUser(id);
  }

  public List<Address> deleteAddress(Long idAddress,String idUser) {
    addressRepository.deleteById(idAddress);
    return addressRepository.getAddressByIdUser(idUser);
  }

  public List<Address> setDefaultAddress(String idUser,Long idAddress) {
    addressRepository.setDefaultAddressMain(idUser);
    addressRepository.setDefaultAddress(idUser, idAddress);
    return addressRepository.findAll();
  }

  public Address getDefaultAddress(String idUser) {
    return addressRepository.getDefaultAddress(idUser);
  }

}
