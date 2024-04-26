package com.ynov.tournaments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.tournaments.model.Gamer;
import com.ynov.tournaments.repository.GamerRepository;


@Service
public class GamerService {

	@Autowired
	private GamerRepository gamerRepository;
	
	public Iterable<Gamer> getGamers(){
		return gamerRepository.findAll();
	}
	
	public Optional<Gamer> getGamer(Integer id) {
		return gamerRepository.findById(id);
	}
	
	public Gamer upsertGamer(Gamer gamer) {
		return gamerRepository.save(gamer);
	}
	
	public void deleteGamer(Integer id){
		gamerRepository.deleteById(id);
	}
}
