package com.venus.brTransport.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venus.brTransport.model.Operation;

import jakarta.transaction.Transactional;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Integer>{
    @Modifying
    @Transactional
	@Query(value="UPDATE operation SET status= ?1 WHERE operation_id= ?2",nativeQuery=true)
	public void UpdataOperarionStatusById(String status,int operation_id);
}
