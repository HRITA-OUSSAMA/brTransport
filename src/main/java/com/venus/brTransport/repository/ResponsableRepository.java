package com.venus.brTransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venus.brTransport.model.Responsable;

@Repository
public interface ResponsableRepository extends CrudRepository<Responsable, Integer>{
       public Responsable findByEmail(String Email);
}
