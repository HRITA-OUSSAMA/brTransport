package com.venus.brTransport.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.brTransport.model.User;
import com.venus.brTransport.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User getUserById(int user_id) {
		return userRepository.findById(user_id)
				.orElseThrow();
	}
	public Iterable<User> getUsers(){
		return userRepository.findAll();
	}
	public User saveUser(User user) {
		return userRepository.save(user);
	}
    public User getUserMail(String mail) {
    	return userRepository.findByMail(mail);
    }
    public void UpdaeUserById(int id,String nom,String prenom,String adresse,String telephone,String email,String password) {
    	userRepository.UpdateUserById(id, nom, prenom, adresse, telephone, email, password);
    }
    public void deleteUserById(int id) {
    	userRepository.deleteById(id);
    }
}
