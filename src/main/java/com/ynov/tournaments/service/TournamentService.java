package com.ynov.tournaments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.tournaments.model.Tournament;
import com.ynov.tournaments.repository.TournamentRepository;

@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;
	
	public Page<Tournament> getTournaments(Pageable pageable, String name, Integer idLangage){
		if(name != null) {
			return tournamentRepository.findAllByName(pageable, name);
		} else if (idLangage != null) {
			return tournamentRepository.findAllByIdLangage(pageable, idLangage);
		} else {
			return tournamentRepository.findAll(pageable);
		}
	}
	
	public Optional<Tournament> getTournament(Integer id) {
		return tournamentRepository.findById(id);
	}
	
	public Tournament upsertTournament(Tournament tournament) {
		return tournamentRepository.save(tournament);
	}
	
	public void deleteTournament(Integer id){
		tournamentRepository.deleteById(id);
	}
}
