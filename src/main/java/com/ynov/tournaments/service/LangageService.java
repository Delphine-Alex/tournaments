package com.ynov.tournaments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.tournaments.model.Langage;
import com.ynov.tournaments.repository.LangageRepository;

@Service
public class LangageService {
	
	@Autowired
	private LangageRepository langageRepository;
	
	public Iterable<Langage> getLangages(){
		return langageRepository.findAll();
	}
	
	public Optional<Langage> getLangage(Integer id) {
		return langageRepository.findById(id);
	}
	
	public Langage upsertLangage(Langage langage) {
		return langageRepository.save(langage);
	}
	
	public void deleteLangage(Integer id){
		langageRepository.deleteById(id);
	}

}
