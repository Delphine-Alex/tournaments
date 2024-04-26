package com.ynov.tournaments.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.tournaments.model.Tournament;
import com.ynov.tournaments.service.TournamentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Tournament", description = "Tournament Controller APIs")
public class TournamentController {
	
	@Autowired
	private TournamentService tournamentService;
	
	@GetMapping("/tournaments")
	public ResponseEntity<Iterable<Tournament>> getTournaments() {
	    Iterable<Tournament> tournaments = tournamentService.getTournaments();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(tournaments);
	}
	
	@GetMapping("/tournament/{id}")
	public ResponseEntity<Tournament> getTournament(@PathVariable("id") Integer id) {
			Optional<Tournament> p = tournamentService.getTournament(id);
			if(p.isPresent()) {
				return new ResponseEntity<Tournament>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/tournaments")
	public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
		Tournament createTournament = tournamentService.upsertTournament(tournament);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createTournament);
	}
	
	@PutMapping("/tournament/{id}")
	public ResponseEntity<Tournament> updateTournament(@PathVariable("id") Integer id, @RequestBody Tournament tournament) {
		
	    Optional<Tournament> existingTournament = tournamentService.getTournament(id);
	    if (existingTournament.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    tournament.setId_tournament(id);
	    Tournament updateTournament = tournamentService.upsertTournament(tournament);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateTournament);
	}
	
	@DeleteMapping("/tournament/{id}")
	public ResponseEntity<Tournament> deleteTournament(@PathVariable("id") Integer id) {
		tournamentService.deleteTournament(id);
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
