package com.venus.brTransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venus.brTransport.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{
	
     public Iterable<Contact> findByVue(int vue);
}
