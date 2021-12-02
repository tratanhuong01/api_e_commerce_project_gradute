package com.api.api_e_commerce_project_gradute.contact;

import com.api.api_e_commerce_project_gradute.DTO.specification.contact.ContactCriteria;
import com.api.api_e_commerce_project_gradute.DTO.specification.contact.ContactSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ContactService {

  @Autowired
  ContactRepository contactRepository;

  public List<Contact> getListContactLimit(ContactCriteria contactCriteria){
    Specification<Contact> contactSpecification = ContactSpecification.createContactSpecification(contactCriteria);
    Pageable pageable = PageRequest.of(contactCriteria.getOffset(),contactCriteria.getLimit());
    return contactRepository.findAll(contactSpecification,pageable).getContent();
  }

  public Integer getListContactAll(ContactCriteria contactCriteria){
    Specification<Contact> contactSpecification = ContactSpecification.createContactSpecification(contactCriteria);
    return contactRepository.findAll(contactSpecification).size();
  }

  public Contact addContact(Contact contact) {
    contact.setTimeCreated(new Timestamp(new Date().getTime()));
    return contactRepository.save(contact);
  }

  public Contact updateContact(Contact contact) {
    return contactRepository.save(contact);
  }

  public void deleteContact(Contact contact) {
    contactRepository.delete(contact);
  }

  public List<Contact> getContactLimit(Integer offset,Integer limit) {
    return contactRepository.getContactLimit(offset,limit);
  }

}
