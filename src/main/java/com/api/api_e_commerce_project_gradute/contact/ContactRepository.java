package com.api.api_e_commerce_project_gradute.contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

  List<Contact> findAll(@Nullable Specification<Contact> contactSpecification);

  Page<Contact> findAll(@Nullable Specification<Contact> contactSpecification, Pageable pageable);


}
