package com.venus.brTransport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.brTransport.model.Lieu;
import com.venus.brTransport.repository.LieuRepository;

@Service
public class LieuService {
	
    @Autowired
    public LieuRepository lieuRepository;
    
    public Iterable<Lieu> getLieux(){
    	return lieuRepository.findAll();
    }
    public Lieu getLieuxById(int lieu_id) {
    	return lieuRepository.findById(lieu_id).orElseThrow();
    }
    public Lieu getLieuEnDeuxParam(String lieu1,String lieu2){
    	return lieuRepository.getLieuEnDeuxParams(lieu1,lieu2);
    }
    public void saveLieux(Lieu lieu) {
    	lieuRepository.save(lieu);
    }

}
