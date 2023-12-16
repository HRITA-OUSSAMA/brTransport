package com.venus.brTransport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.brTransport.model.Contact;
import com.venus.brTransport.repository.ContactRepository;

@Service
public class MessageService {
	@Autowired
	ContactRepository messageRepository;
	
      public void saveMessage(Contact message) {
    	  messageRepository.save(message);
      }
      
      public List<Contact> getMessages(){
    	 return (List<Contact>) messageRepository.findAll();
      }
      
      public int getMessagesNoVueNumber() {
    	  int n=0;
    	  List<Contact> contacts=getMessages();
    	  for(int i=0;i<contacts.size();i++) {
    		  if(contacts.get(i).getVue()==0) {
    			  n=n+1;
    		  }
    	  }
    	  return n;
      }
      
     public Iterable<Contact> getMessageNonVue(){
    	 return messageRepository.findByVue(0);
     }
}
