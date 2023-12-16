package com.venus.brTransport.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.brTransport.model.Lieu;
import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.model.Operation;
import com.venus.brTransport.model.OperationAdminCard;
import com.venus.brTransport.model.OperationCard;
import com.venus.brTransport.model.User;
import com.venus.brTransport.repository.OperationRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class OperationService {
	
	@Autowired
	OperationRepository operationRepository;
	@Autowired
	UserService userService;
	@Autowired
	LieuService lieuService;
	
	public void saveOperation(Operation operation) {
		operationRepository.save(operation);
	}
    public List<Operation> getOperationUser(int user_id){
          User user=userService.getUserById(user_id);
          return user.getOperations();
    }
    
    public List<OperationCard> getOperationsCards(int user_id){
    	List<OperationCard> operationCards=new ArrayList<>();
    	List<Operation> operations=getOperationUser(user_id);
    	for(int i=0;i<operations.size();i++){ 
    		OperationCard operationCard=new OperationCard();
    		List<Marchandise> marchandises=operations.get(i).getMarchandises();
    		int marchandise_id=marchandises.get(0).getMarchandise_id();
    		int lieu_id=operations.get(i).getLieu_id();
    		Lieu lieu=lieuService.getLieuxById(lieu_id);
    		operationCard.setLieu1(lieu.getLieu1());
    		operationCard.setLieu2(lieu.getLieu2());
			operationCard.setMarchandise_id(marchandise_id);
			operationCard.setOperation_id(operations.get(i).getOperation_id());
			operationCard.setStatus(operations.get(i).getStatus());
			operationCards.add(operationCard);
    	};
    	return operationCards;
    }
    public Operation getOperationByAttribute(String user_id,String lieu_id,String status,List<Marchandise> marchandises,HttpServletRequest request) {
    	Operation operation=new Operation();
		  operation.setStatus(status);
		  int user_id1=(int) request.getSession().getAttribute(user_id);
		  int lieu_id1=(int) request.getSession().getAttribute(lieu_id);
		  operation.setUser_id(user_id1);
		  operation.setLieu_id(lieu_id1);
		  operation.setMarchandises(marchandises);
		  return operation;
    }
    public void deleteOperationById(int id) {
    	operationRepository.deleteById(id);
    }
    public void UpdataOperarionStatusById(String status,int operation_id) {
    	operationRepository.UpdataOperarionStatusById(status, operation_id);
    }
    
    public Iterable<Operation> getOperations(){
    	return operationRepository.findAll();
    }
    
    public List<OperationAdminCard> getOperationAdminCards(){
    	List<OperationAdminCard> operationAdminCards=new ArrayList<>();
    	List<Operation> operations=(List<Operation>) getOperations();
    	for(int i=0;i<operations.size();i++) {
    		OperationAdminCard operationAdminCard=new OperationAdminCard();
    		operationAdminCard.setOperation_id(operations.get(i).getOperation_id());
    		operationAdminCard.setStatus(operations.get(i).getStatus());
    		User user=userService.getUserById(operations.get(i).getUser_id());
    		operationAdminCard.setNom(user.getNom());
    		operationAdminCard.setPrenom(user.getPrenom());
    		operationAdminCards.add(operationAdminCard);
    	}
    	return operationAdminCards;
    }
    
}
