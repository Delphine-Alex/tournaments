package com.ynov.tournaments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.tournaments.model.Gamer;
import com.ynov.tournaments.repository.GamerRepository;


@Service
public class GamerService {

	@Autowired
	private GamerRepository gamerRepository;
	
	public Page<Gamer> getGamers(Pageable pageable, String pseudo, Integer ranking){
		if(pseudo != null) {
			return gamerRepository.findAllByPseudo(pageable, pseudo);
		} else if(ranking != null) {
			return gamerRepository.findByRanking(ranking, pageable);
		} else {
			return gamerRepository.findAll(pageable);
		}
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
