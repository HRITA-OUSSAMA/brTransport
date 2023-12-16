package com.venus.brTransport.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venus.brTransport.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
           public User findByMail(String mail);
           @Transactional
           @Modifying
           @Query(value="UPDATE user SET nom=?2,prenom=?3,adresse=?4,telephone=?5,Email=?6,password=?7 WHERE user_id=?1",nativeQuery=true)
           public void UpdateUserById(int id,String nom,String prenom,String adresse,String telephone,String email,String password);
}
