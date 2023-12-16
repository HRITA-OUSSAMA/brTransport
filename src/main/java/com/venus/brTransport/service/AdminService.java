package com.venus.brTransport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.brTransport.model.Responsable;
import com.venus.brTransport.repository.ResponsableRepository;

@Service
public class AdminService {
     @Autowired
     ResponsableRepository responsableRepository;
     
     public Iterable<Responsable> getResponsables(){
    	 return responsableRepository.findAll();
     }
     public Responsable getResponsableByEmail(String Email) {
    	 return responsableRepository.findByEmail(Email);
     }
}
