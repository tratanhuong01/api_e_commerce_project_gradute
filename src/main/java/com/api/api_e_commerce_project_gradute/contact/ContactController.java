package com.api.api_e_commerce_project_gradute.contact;

import com.api.api_e_commerce_project_gradute.DTO.specification.contact.ContactCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class ContactController {

  @Autowired
  ContactService contactService;

  @GetMapping("contactFilters")
  public List<Contact> getListContactLimit(String timeCreated,String timeCreatedFrom,
                                           String timeCreatedTo,Integer offset,
                                           Integer limit,String keyword,Integer status) {
    ContactCriteria contactCriteria = ContactCriteria.builder()
        .timeCreated(timeCreated)
        .timeCreatedFrom(timeCreatedFrom)
        .timeCreatedTo(timeCreatedTo)
        .keyword(keyword)
        .offset(offset)
        .limit(limit)
        .status(status)
        .build();
    return contactService.getListContactLimit(contactCriteria);
  }

  @GetMapping("contactFiltersAll")
  public Integer getListContactAll(String timeCreated,String timeCreatedFrom,String keyword,
                                   String timeCreatedTo,Integer status) {
    ContactCriteria contactCriteria = ContactCriteria.builder()
        .timeCreated(timeCreated)
        .timeCreatedFrom(timeCreatedFrom)
        .keyword(keyword)
        .timeCreatedTo(timeCreatedTo)
        .status(status)
        .build();
    return contactService.getListContactAll(contactCriteria);
  }

  @PostMapping("contacts")
  public Contact addContact(@RequestBody Contact contact) {
    return contactService.addContact(contact);
  }

  @PutMapping("contacts")
  public Contact updateContact(@RequestBody Contact contact) {
    return contactService.updateContact(contact);
  }

  @DeleteMapping("contacts")
  public void deleteContact(@RequestBody Contact contact) {
    contactService.deleteContact(contact);
  }

  @GetMapping("contacts")
  public List<Contact> getContactLimit(@RequestParam Integer offset,@RequestParam Integer limit) {
    return contactService.getContactLimit(offset,limit);
  }

}
