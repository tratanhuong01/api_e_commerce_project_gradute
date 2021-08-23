package com.api.api_e_commerce_project_gradute.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

  @Autowired
  AddressService addressService;

  @CrossOrigin
  @GetMapping("addresses")
  public List<Address> getAllAddress() {
    return addressService.getAllAddress();
  }

  @CrossOrigin
  @GetMapping("addresses/{id}")
  public List<Address> getAddressByIdUser(@PathVariable String id) {
    return addressService.getAddressByIdUser(id);
  }

  @CrossOrigin
  @PostMapping("addresses")
  public List<Address> addAddress(@RequestBody Address address) {
    return addressService.addAddress(address);
  }

  @CrossOrigin
  @PutMapping("addresses")
  public List<Address>  updateAddress(@RequestBody Address address) {
    return addressService.addAddress(address);
  }

  @CrossOrigin
  @DeleteMapping("addresses/{id}")
  public List<Address> deleteAddress(@PathVariable Long id) {
    return addressService.deleteAddress(id);
  }

  @CrossOrigin
  @PutMapping("setDefaultAddress/{idUser}/{idAddress}")
  public List<Address> setDefaultAddress(@PathVariable String idUser,@PathVariable Long idAddress) {
    return addressService.setDefaultAddress(idUser,idAddress);
  }

  @CrossOrigin
  @GetMapping("getDefaultAddress/{id}")
  public Address getDefaultAddress(@PathVariable String id) {
    return addressService.getDefaultAddress(id);
  }

}
