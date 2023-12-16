package com.venus.brTransport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venus.brTransport.model.Lieu;

@Repository
public interface LieuRepository extends CrudRepository<Lieu, Integer>{
	
	 @Query(value = "SELECT * FROM lieu WHERE lieu1 = :lieu1 and lieu2 = :lieu2", nativeQuery = true)
	 public Lieu getLieuEnDeuxParams(@Param("lieu1") String lieu1,@Param("lieu2") String lieu2);

}
