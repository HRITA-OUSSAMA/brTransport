package com.venus.brTransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venus.brTransport.model.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Integer>{

}
