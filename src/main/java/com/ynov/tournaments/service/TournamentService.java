package com.ynov.tournaments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.tournaments.model.Tournament;
import com.ynov.tournaments.repository.TournamentRepository;

@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;
	
	public Iterable<Tournament> getTournaments(){
		return tournamentRepository.findAll();
	}
	
	public Optional<Tournament> getTournament(Integer id) {
		return tournamentRepository.findById(id);
	}
}
