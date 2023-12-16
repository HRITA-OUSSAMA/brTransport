package com.venus.brTransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venus.brTransport.model.Marchandise;

@Repository
public interface MarchandiseRepository extends CrudRepository<Marchandise, Integer>{

}
