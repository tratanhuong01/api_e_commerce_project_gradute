package com.api.api_e_commerce_project_gradute.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class AddressController {

  @Autowired
  AddressService addressService;

  @GetMapping("addresses")
  public List<Address> getAllAddress() {
    return addressService.getAllAddress();
  }

  @GetMapping("addresses/{id}")
  public List<Address> getAddressByIdUser(@PathVariable String id) {
    return addressService.getAddressByIdUser(id);
  }

  @PostMapping("addresses")
  public List<Address> addAddress(@RequestParam(required = false) String idUser,@RequestBody Address address) {
    return addressService.addAddress(address);
  }

  @PutMapping("addresses")
  public List<Address>  updateAddress(@RequestBody Address address) {
    return addressService.addAddress(address);
  }

  @DeleteMapping("addresses")
  public List<Address> deleteAddress(@RequestParam(required = false) Long idAddress,@RequestParam(required = false) String idUser) {
    return addressService.deleteAddress(idAddress,idUser);
  }

  @PutMapping("setDefaultAddress/{idUser}/{idAddress}")
  public List<Address> setDefaultAddress(@PathVariable String idUser,@PathVariable Long idAddress) {
    return addressService.setDefaultAddress(idUser,idAddress);
  }

  @GetMapping("getDefaultAddress/{id}")
  public Address getDefaultAddress(@PathVariable String id) {
    return addressService.getDefaultAddress(id);
  }

}
